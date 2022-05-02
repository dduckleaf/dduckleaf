package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.email.EmailSender;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.profile.entity.Member;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import com.greedy.dduckleaf.profile.repository.MemberForProfileRepository;
import com.greedy.dduckleaf.profile.repository.ProfileAttachmentForProfileRepository;
import com.greedy.dduckleaf.projectnotice.dto.ProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class : ProfileService
 * Comment : 프로필
 * History
 * 2022/04/29 (박상범) 처음 작성 / 회원 번호를 통해 프로필 사진정보와, 회원정보 조회 관련 메소드 작성
 * 2022/04/30 (박상범) 회원의 사진 정보 변경 관련 메소드 작성
 * 2022/05/01 (박상범) 회원의 프로필 사진정보 조회, 회원정보 조회 관련 메소드 수정
 * 2022/05/02 (박상범) 이메일 인증번호 전송 관련 메소드 작성, 회원의 이메일 변경 관련 메소드 작성
 * </pre>
 * @version 1.0.3
 * @author 박상범
 */
@Service
public class ProfileService {

    private final MemberForProfileRepository memberForProfileRepository;
    private final ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository;
    private final ModelMapper modelMapper;
    private final EmailSender emailSender;

    @Autowired
    public ProfileService(MemberForProfileRepository memberForProfileRepository, ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository, ModelMapper modelMapper, EmailSender emailSender) {
        this.memberForProfileRepository = memberForProfileRepository;
        this.profileAttachmentForProfileRepository = profileAttachmentForProfileRepository;
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

        return new ProfileDTO(member, profileAttachment);
    }

    /**
     * modifyAttachment: 회원의 사진 정보를 변경합니다.
     * @param attachment: 변경할 사진 정보를 담은 ProfileAttachmentDTO 객체
     * @return "true"
     * @author 박상범
     */
    @Transactional
    public String modifyAttachment(ProfileAttachmentDTO attachment) {

        System.out.println(attachment);

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
    }
}
