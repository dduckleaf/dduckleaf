package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.email.EmailSender;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.profile.entity.BasicProfileAttachment;
import com.greedy.dduckleaf.profile.entity.Member;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import com.greedy.dduckleaf.profile.repository.BasicProfileAttachmentForProfileRepository;
import com.greedy.dduckleaf.profile.repository.MemberForProfileRepository;
import com.greedy.dduckleaf.profile.repository.ProfileAttachmentForProfileRepository;
import com.greedy.dduckleaf.profile.dto.ProfileDTO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

/**
 * <pre>
 * Class : ProfileService
 * Comment : 프로필
 * History
 * 2022/04/29 (박상범) 처음 작성 / 회원 번호를 통해 프로필 사진정보와, 회원정보 조회 관련 메소드 작성
 * 2022/04/30 (박상범) 회원의 사진 정보 변경 관련 메소드 작성
 * 2022/05/01 (박상범) 회원의 프로필 사진정보 조회, 회원정보 조회 관련 메소드 수정
 * 2022/05/02 (박상범) 이메일 인증번호 전송 관련 메소드 작성, 회원의 이메일 변경 관련 메소드 작성, 휴대전화 번호로 인증번호 전송 관련 메소드 작성, 회원의 휴대전화 번호 변경 관련 메소드 작성, 회원의 비밀번호 변경 관련 메소드 작성
 * 2022/05/03 (박상범) 프로필 이미지 사진 기본 이미지로 변경 관련 메소드 작성
 * </pre>
 * @version 1.0.5
 * @author 박상범
 */
@Service
public class ProfileService {

    private final MemberForProfileRepository memberForProfileRepository;
    private final ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository;
    private final BasicProfileAttachmentForProfileRepository basicProfileAttachmentForProfileRepository;
    private final ModelMapper modelMapper;
    private final EmailSender emailSender;

    @Autowired
    public ProfileService(MemberForProfileRepository memberForProfileRepository, ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository, BasicProfileAttachmentForProfileRepository basicProfileAttachmentForProfileRepository, ModelMapper modelMapper, EmailSender emailSender) {
        this.memberForProfileRepository = memberForProfileRepository;
        this.profileAttachmentForProfileRepository = profileAttachmentForProfileRepository;
        this.basicProfileAttachmentForProfileRepository = basicProfileAttachmentForProfileRepository;
        this.modelMapper = modelMapper;
        this.emailSender = emailSender;
    }

    /**
     * findProfileByMemberNo: 회원 번호를 통해 프로필 사진 정보, 회원 정보를 조회합니다.
     * @param memberNo: 로그인된 회원의 번호
     * @return 펀딩 횟수, 모의펀딩 횟수, 티켓 갯수를 담은 MyFundingDTO 객체를 리턴합니다.
     * @author 박상범
     */
    public ProfileDTO findProfileByMemberNo(int memberNo) {

        ProfileAttachmentDTO profileAttachment = modelMapper.map(profileAttachmentForProfileRepository.findProfileAttachmentByMember_memberNo(memberNo), ProfileAttachmentDTO.class);
        MemberDTO member = modelMapper.map(memberForProfileRepository.findById(memberNo).get(), MemberDTO.class);

        return new ProfileDTO(profileAttachment, member);
    }

    /**
     * modifyAttachment: 회원의 사진 정보를 변경합니다.
     * @param attachment: 변경할 사진 정보를 담은 ProfileAttachmentDTO 객체
     * @return "true"
     * @author 박상범
     */
    @Transactional
    public String modifyAttachment(ProfileAttachmentDTO attachment) {

        ProfileAttachment profileAttachment = profileAttachmentForProfileRepository.findProfileAttachmentByMember_memberNo(attachment.getMemberNo());

        if(profileAttachment == null) {
            profileAttachmentForProfileRepository.save(modelMapper.map(attachment, ProfileAttachment.class));
        }
        if(profileAttachment != null) {
            profileAttachment.setProfileOriginalName(attachment.getProfileOriginalName());
            profileAttachment.setProfileSavedName(attachment.getProfileSavedName());
            profileAttachment.setProfilePath(attachment.getProfilePath());
            profileAttachment.setProfileThumbnailPath(attachment.getProfileThumbnailPath());
        }

        return "true";
    }

    /**
     * sendEmailVerification: 입력받은 이메일 주소로 인증번호를 전송한다.
     * @param email:  인증 번호를 받을 이메일 주소
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String sendEmailVerification(String email) {

        Member foundMember = memberForProfileRepository.findMemberByEmail(email);

        if(foundMember != null) {
            return "이미 사용중인 이메일 입니다.";
        }

        return emailSender.sendMailVerification(email);
    }

    /**
     * modifyEmail: 회원의 이메일 주소를 변경합니다.
     * @param member:  회원 번호와 이메일을 담은 MemberDTO 객체
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public void modifyEmail(MemberDTO member) {

        Member foundMember = memberForProfileRepository.findById(member.getMemberNo()).get();
        foundMember.setEmail(member.getEmail());

        memberForProfileRepository.save(foundMember);
    }

    /**
     * sendPhoneVerification: 입력받은 휴대전화 번호로 인증번호를 전송한다.
     * @param phone:  인증 번호를 받을 휴대폰 번호
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    public String sendPhoneVerification(String phone) {

        Member member = memberForProfileRepository.findMemberByPhone(phone);

        if(phone.isEmpty()) {
            return "휴대전화 번호를 입력해주세요.";
        }
        if(member != null) {
            return "이미 사용중인 휴대전화 번호입니다.";
        }

        String code = (int) (Math.random() * 899999) + 100000 + "";
        String api_key = "NCSMW5CKIIGCIUO1";
        String api_secret = "GTY9AORLARLD0KNOSO1AND3KFOREO9N9";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", phone);
        params.put("from", "01066933114");
        params.put("type", "SMS");
        params.put("text", code);
        params.put("app_version", "test app 1.2");

        JSONObject obj = new JSONObject();

        try {
            obj = coolsms.send(params);
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
     * modifyPhone: 회원의 휴대전화 번호를 변경합니다.
     * @param member:  회원 번호와 휴대전화 번호를 담은 MemberDTO 객체
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    @Transactional
    public void modifyPhone(MemberDTO member) {

        Member foundMember = memberForProfileRepository.findById(member.getMemberNo()).get();
        foundMember.setPhone(member.getPhone());

        memberForProfileRepository.save(foundMember);
    }

    /**
     * modifyMemberPwd: 회원의 비밀번호를 변경합니다.
     * @param member:  회원 번호와 비밀번호를 담은 MemberDTO 객체
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    @Transactional
    public void modifyMemberPwd(MemberDTO member) {

        Member foundMember = memberForProfileRepository.findById(member.getMemberNo()).get();
        foundMember.setMemberPwd(member.getMemberPwd());

        memberForProfileRepository.save(foundMember);
    }

    /**
     * removeProfileAttachment: 회원의 프로필 이미지를 기본이미지로 변경합니다.
     * @param memberNo:  회원 번호
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박상범
     */
    @Transactional
    public String removeProfileAttachment(int memberNo) {

        ProfileAttachment profileAttachment = profileAttachmentForProfileRepository.findProfileAttachmentByMember_memberNo(memberNo);

        if(profileAttachment == null) {
            return "프로필 사진 삭제 실패";
        }

        int basicProfileAttachmentNo = (int) ((Math.random() * 6) + 1);

        BasicProfileAttachment basicProfileAttachment = basicProfileAttachmentForProfileRepository.findById(basicProfileAttachmentNo).get();

        System.out.println(profileAttachment);
        System.out.println(basicProfileAttachment);

        profileAttachment.setProfileSavedName(basicProfileAttachment.getProfileSavedName());
        profileAttachment.setProfileOriginalName(basicProfileAttachment.getProfileOriginalName());
        profileAttachment.setProfilePath(basicProfileAttachment.getProfilePath());
        profileAttachment.setProfileThumbnailPath(basicProfileAttachment.getProfileThumbnailPath());

        return profileAttachment.getProfileThumbnailPath();
    }
}
