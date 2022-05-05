package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.profile.entity.BasicProfileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : BasicProfileAttachmentForProfileRepository
 * Comment : 프로필
 * History
 * 2022/05/03 (박상범) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
public interface BasicProfileAttachmentForProfileRepository extends JpaRepository<BasicProfileAttachment, Integer> {

}
