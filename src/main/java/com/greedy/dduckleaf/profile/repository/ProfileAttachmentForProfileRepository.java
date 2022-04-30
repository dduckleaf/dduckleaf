package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.profile.entity.Member;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileAttachmentForProfileRepository extends JpaRepository<ProfileAttachment, Integer> {

    ProfileAttachment findProfileAttachmentByMember_memberNo(int memberNo);
}
