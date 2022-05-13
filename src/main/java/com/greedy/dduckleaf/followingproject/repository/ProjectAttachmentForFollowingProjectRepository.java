package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.followingproject.entity.ProjectAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class: ProjectAttachmentForFollowingProjectRepository
 * Comment : 관심 프로젝트
 * History
 * 2022/05/13 (박상범) 처음 작성 / 프로젝트 사진 목록 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface ProjectAttachmentForFollowingProjectRepository extends JpaRepository<ProjectAttachment, Integer> {

    List<ProjectAttachment> findByProjectProjectNo(int projectNo);
}
