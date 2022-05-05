package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.profile.entity.Member;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Interface : ProfileAttachmentForProfileRepository
 * Comment : 마이펀딩
 * History
 * 2022/04/28 (박상범) 처음 작성 / 프로필 사진 정보 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
@Repository
public interface ProfileAttachmentForProfileRepository extends JpaRepository<ProfileAttachment, Integer> {

    ProfileAttachment findProfileAttachmentByMember_memberNo(int memberNo);
}
