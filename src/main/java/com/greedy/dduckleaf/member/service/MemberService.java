package com.greedy.dduckleaf.member.service;

import com.greedy.dduckleaf.email.EmailSender;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.entity.Member;
import com.greedy.dduckleaf.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * <pre>
 * Class : MemberService
 * Comment : 회원관리
 * History
 * 2022/04/18 (박상범) 처음 작성
 * 2022/04/19 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 시작
 * 2022/04/21 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 완료
 * </pre>
 * @version 1.0.3
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

        List<Member> member = memberRepository.findMemberByEmail(email);

        //중복된 이메일을 가진 멤버가 없을 경우
        if(member.size() == 0) {
            emailSender.sendMail(email);
        }
        if(member.size() > 0) {
            return "이미 사용중인 이메일 입니다.";
        }

        return (int) (Math.random() * 899999) + 100000 + "";
    }
}
