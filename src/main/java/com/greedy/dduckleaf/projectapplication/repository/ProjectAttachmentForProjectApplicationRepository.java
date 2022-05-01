package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Interface : ProjectAttachmentForProjectApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/05/01 (박휘림) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
public interface ProjectAttachmentForProjectApplicationRepository extends JpaRepository<ProjectAttachment, Integer> {

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '대표이미지'", nativeQuery = true)
    ProjectAttachment findByProjectNo(int projectNo);
}
