package com.greedy.dduckleaf.member.service;

import com.greedy.dduckleaf.email.EmailSender;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.entity.Member;
import com.greedy.dduckleaf.member.repository.MemberRepository;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * Class : MemberService
 * Comment : 회원관리
 * History
 * 2022/04/18 (박상범) 처음 작성
 * 2022/04/19 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 시작
 * 2022/04/21 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 완료
 * 2022/04/22 (박상범) 휴대폰 인증번호 전송 관련 메소드 구현 완료, 아이디 중복 체크 관련 메소드 구현 완료, 회원 가입 관련 메소드 구현 완료
 * 2022/04/23 (박상범) 아이디 찾기 관련 메소드 구현 완료
 * 2022/04/24 (박상범) 비밀번호 찾기 관련 메소드 구현 완료
 * </pre>
 * @version 1.0.7
 * @author 박상범
 * @see EmailSender
 * @see ModelMapper
 */
@Service
public class MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;

    @Autowired
    public MemberService(ModelMapper modelMapper, MemberRepository memberRepository, EmailSender emailSender) {
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
        this.emailSender = emailSender;
    }
 
    /**
     * sendEmailVerification: 입력받은 이메일 주소로 인증번호를 전송한다.
     * @param email: 인증 번호를 받을 이메일 주소
     * @return 결과에 따라 다른 메시지를 return한다.
     * @author 박상범
     */
    public String sendEmailVerification(String email) throws MessagingException {

        Member member = memberRepository.findMemberByEmail(email);

        //중복된 이메일을 가진 멤버가 있을 경우
        if(member != null) {
            return "이미 사용중인 이메일 입니다.";
        }

        return emailSender.sendMailVerification(email);
    }

    /**
     * sendPhoneVerification: 입력받은 휴대폰 번호로 인증번호를 전송합니다.
     * @param phone: 인증 번호를 받을 휴대폰 번호
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String sendPhoneVerification(String phone) {

        Member member = memberRepository.findMemberByPhone(phone);

        if(phone.length() == 0){
            return "휴대폰 번호를 입력해주세요.";
        }

        if(phone.length() > 0 && !(phone.length() == 11)) {
            return "휴대폰 번호가 유효하지 않습니다.";
        }

        if(member == null) {
            return "이미 사용중인 휴대전화 번호입니다.";
        }

        String code = (int) (Math.random() * 899999) + 100000 + "";
        String api_key = "NCS2DRV64W2NLRRJ";
        String api_secret = "KHIZVNRLB6BCFXT9OKV3EUHBGZNYXRMV";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", phone);
        params.put("from", "01062019811");
        params.put("type", "SMS");
        params.put("text", code);
        params.put("app_version", "test app 1.2");

        JSONObject obj = new JSONObject();

        try {
            obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch(CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        if("".equals(obj)) {
            return  "인증번호 전송 실패";
        }

        return code;
    }

    /**
     * checkDuplicationMemberId: 아이디 중복 확인을 합니다.
     * @param memberId: 중복 확인할 아이디
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String checkDuplicationMemberId(String memberId) {

        if(memberId.isEmpty() || memberId.isBlank()) {
            return "아이디를 입력해주세요.";
        }

        if(memberRepository.findMemberByMemberId(memberId) != null ) {
            return "중복된 아이디입니다.";
        }

        return "사용가능한 아이디입니다.";
    }

    /**
     * registMember : 입력받은 회원 정보로 회원 가입을 합니다.
     * @param member: 회원 가입할 회원 정보
     * @author 박상범
     */
    @Transactional
    public void registMember(MemberDTO member) {
        memberRepository.save(modelMapper.map(member, Member.class));
    }
 
    /**
     * sendEmailMemberId: 입력한 이메일이 등록되어있는지 확인합니다.
     * @param email: 중복 확인할 아이디
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String sendEmailMemberId(String email) {

        Member member = memberRepository.findMemberByEmail(email);

        //등록된 이메일이 없는 경우
        if(member == null) {
            return "등록된 아이디가 없습니다.";
        }

        return emailSender.sendMailMemberId(member);
    }

    /**
     * findMember: 입력한 이메일이 등록되어있는지 확인합니다.
     * @param member: 중복 확인할 아이디
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String findMember(MemberDTO member) {

        Member foundMember = memberRepository.findMember(member.getMemberId(), member.getEmail());

        if(foundMember == null) {
            return "아이디와 이메일이 일치하는 회원의 정보가 없습니다.";
        }

        return emailSender.sendMailVerification(member.getEmail());
    }

    /**
     * modifyMemberPwd: 회원의 비밀번호를 변경합니다.
     * @param member: 회원번호와 변경할 비밀번호를 담은 MemberDTO 객체
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    @Transactional
    public String modifyMemberPwd(MemberDTO member) {

        Member foundMember = memberRepository.findMemberByMemberNo(member.getMemberNo());

        if(foundMember != null) {
            foundMember.setMemberPwd(member.getMemberPwd());

            return "비밀번호가 변경되었습니다. 로그인페이지로 이동힙니다.";
        }

        return "비밀번호 변경 실패";
    }
}
