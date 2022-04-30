package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
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
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
@Service
public class ProfileService {

    private final MemberForProfileRepository memberForProfileRepository;
    private final ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProfileService(MemberForProfileRepository memberForProfileRepository, ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository, ModelMapper modelMapper) {
        this.memberForProfileRepository = memberForProfileRepository;
        this.profileAttachmentForProfileRepository = profileAttachmentForProfileRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProfileByMemberNo: 회원 번호를 통해 프로필 사진 정보, 회원 정보를 조회합니다.
     * @param memberNo: 로그인된 회원의 번호
     * @return 펀딩 횟수, 모의펀딩 횟수, 티켓 갯수를 담은 MyFundingDTO 객체를 리턴합니다.
     * @author 박상범
     */
    public ProfileDTO findProfileByMemberNo(int memberNo) {

        ProfileDTO profile = new ProfileDTO();

        MemberDTO member = modelMapper.map(memberForProfileRepository.findById(memberNo).get(), MemberDTO.class);
        ProfileAttachmentDTO profileAttachment = modelMapper.map(profileAttachmentForProfileRepository.findProfileAttachmentByMember_memberNo(memberNo), ProfileAttachmentDTO.class);
        profile.setMember(member);
        profile.setProfileAttachment(profileAttachment);

        return profile;
    }
}
