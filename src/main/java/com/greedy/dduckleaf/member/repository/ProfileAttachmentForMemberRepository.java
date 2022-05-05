package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.ProfileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : ProfileAttachmentForMemberRepository
 * Comment : 회원관리
 * History
 * 2022/05/04 (박상범) 처음 작성 / 회원번호의 프로필 사진 정보 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
public interface ProfileAttachmentForMemberRepository extends JpaRepository<ProfileAttachment, Integer> {

    ProfileAttachment findProfileAttachmentByMember_memberNo(int memberNo);
}
