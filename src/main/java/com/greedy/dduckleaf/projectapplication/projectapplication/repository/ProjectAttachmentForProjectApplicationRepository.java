package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectAttachment;
import com.greedy.dduckleaf.projectapplication.entity.ProjectBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : ProjectAttachmentForProjectApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/05/01 (박휘림) 처음 작성
 * 2022/05/01 (박휘림) findBasicInfoAttachmentByProjectNo, findStoryAttachmentByProjectNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface ProjectAttachmentForProjectApplicationRepository extends JpaRepository<ProjectAttachment, Integer> {

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '대표이미지'", nativeQuery = true)
    ProjectAttachment findBasicInfoAttachmentByProjectNo(int projectNo);

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '스토리사진'", nativeQuery = true)
    ProjectAttachment findStoryAttachmentByProjectNo(int projectNo);

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '소개사진'", nativeQuery = true)
    ProjectAttachment findIntroAttachmentByProjectNo(int projectNo);

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '파머사진'", nativeQuery = true)
    ProjectAttachment findFarmerInfoAttachment(int projectNo);

    @Query(value = "SELECT * FROM TBL_PROJECT_ATTACHMENT A WHERE A.PROJECT_NO = :projectNo AND A.PROJECT_ATTACHMENT_CATEGORY = '금융정보'", nativeQuery = true)
    List<ProjectAttachment> findFarmerFinancialInfoAttachment(int projectNo);
}
