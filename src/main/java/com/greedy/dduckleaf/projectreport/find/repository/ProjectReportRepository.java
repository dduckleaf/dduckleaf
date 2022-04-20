package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {

//    List<ProjectReport> findByMemberId(String memberId);

    @Query(value = "SELECT A.PROJECT_REPORT_NO, A.PROJECT_REPORT_DATE, A.PROJECT_REPORT_STATUS, B.PROJECT_NAME " +
                     "FROM TBL_PROJECT_REPORT A JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO) " +
                 "ORDER BY A.PROJECT_REPORT_NO DESC",
    nativeQuery = true)
    List<ProjectReport> findProjectReportListByMemberId(String memberId);
}
