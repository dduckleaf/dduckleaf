package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.BasicProfileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : BasicProfileAttachmentForMemberRepository
 * Comment : 회원관리
 * History
 * 2022/05/04 (박상범) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
public interface BasicProfileAttachmentForMemberRepository extends JpaRepository<BasicProfileAttachment, Integer> {

}
