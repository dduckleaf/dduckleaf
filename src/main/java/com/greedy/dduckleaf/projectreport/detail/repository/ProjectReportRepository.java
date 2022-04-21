package com.greedy.dduckleaf.projectreport.detail.repository;

import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.detail.entity.ReportCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {

//    ProjectReport findByProjectReportNo(int projectReportNo);
    List<ProjectReport> findAll();

    @Query(value = "SELECT\n" +
                    "       A.PROJECT_REPORT_NO\n" +
                    "     , A.PROJECT_REPORT_DATE\n" +
                    "     , A.PROJECT_REPORT_CONTENT\n" +
                    "     , A.REPORT_REF_URL\n" +
                    "     , A.REPORTER_PHONE\n" +
                    "     , A.REPORTER_EMAIL\n" +
                    "     , A.REPORTER_NAME\n" +
                    "     , A.MEMBER_NO\n" +
                    "     , A.FARMER_NO\n" +
                    "     , A.PROJECT_NO\n" +
                    "     , B.REPORT_CATEGORY_NO\n" +
                    "     , B.REPORT_CATEGORY_NAME\n" +
                    "  FROM TBL_PROJECT_REPORT A\n" +
                    "  JOIN TBL_REPORT_CATEGORY B ON (A.PROJECT_REPORT_CATEGORY_NO = B.REPORT_CATEGORY_NO)"
                    , nativeQuery = true)
    List<Object> findReportAndReply();
}
