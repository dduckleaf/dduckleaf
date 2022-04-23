package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {

    /**
    * 모든 프로젝트신고내역 목록조회용 메소드
    *  @param pageable: 페이징에 필요한 정보를 담는 객체
    * @return 한 페이지에 담길 프로젝트신고목록 리스트
    */
    Page<ProjectReport> findAll(Pageable pageable);

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

    /**
    * 모든 프로젝트 신고내역 데이터를 데이터베이스에 요청하기 위한 메소드입니다.
    * @return 모든 프로젝트 신고내역
    */
    @Query(value = "SELECT\n" +
            "       A.PROJECT_REPORT_NO\n" +
            "     , A.PROJECT_REPORT_DATE\n" +
            "     , A.PROJECT_REPORT_CONTENT\n" +
            "     , A.REPORT_REF_URL\n" +
            "     , A.REPORTER_PHONE\n" +
            "     , A.REPORTER_EMAIL\n" +
            "     , A.REPORTER_NAME\n" +
            "     , A.PROJECT_REPORT_STATUS\n" +
            "     , C.MEMBER_ID\n" +
            "     , D.PROJECT_NAME\n" +
            "     , B.REPORT_CATEGORY_NAME\n" +
            "  FROM TBL_PROJECT_REPORT A\n" +
            "  JOIN TBL_REPORT_CATEGORY B ON (A.PROJECT_REPORT_CATEGORY_NO = B.REPORT_CATEGORY_NO)\n" +
            "  JOIN TBL_MEMBER C ON (A.MEMBER_NO = C.MEMBER_NO)\n" +
            "  JOIN TBL_PROJECT D ON (A.PROJECT_NO = D.PROJECT_NO)",
    nativeQuery = true)
    List<Object> findAllProjectReport();
}
