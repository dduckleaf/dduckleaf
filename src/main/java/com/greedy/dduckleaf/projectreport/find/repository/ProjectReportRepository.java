package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {

    List<ProjectReport> findAll();

    @Query(value = "SELECT A.PROJECT_REPORT_NO, A.PROJECT_REPORT_DATE, C.REPORT_CATEGORY_NAME, A.PROJECT_REPORT_STATUS, a.member_no \n" +
            "  FROM TBL_PROJECT_REPORT AS A \n" +
            "  JOIN TBL_REPORT_CATEGORY AS C ON (A.PROJECT_REPORT_CATEGORY_NO = C.REPORT_CATEGORY_NO)", nativeQuery = true)
    List<ProjectReport> findAllWithCategory();






    @Query(value = "SELECT A.PROJECT_REPORT_NO, A.PROJECT_REPORT_DATE, C.REPORT_CATEGORY_NAME, A.PROJECT_REPORT_STATUS, B.PROJECT_NAME " +
                     "FROM TBL_PROJECT_REPORT A " +
                     "JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO) " +
                     "JOIN TBL_REPORT_CATEGORY C ON (A.PROJECT_REPORT_CATEGORY_NO = C.REPORT_CATEGORY_NO) " +
                    "WHERE A.MEMBER_NO = :memberNo " +
                 "ORDER BY A.PROJECT_REPORT_NO DESC",
    nativeQuery = true)
    List<Object> findProjectReportListByMemberNo(int memberNo);
}
