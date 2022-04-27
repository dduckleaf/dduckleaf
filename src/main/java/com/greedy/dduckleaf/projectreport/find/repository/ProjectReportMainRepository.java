package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : ProjectReportRepository
 * Comment : ProjectReport 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-18 (장민주) 처음 작성
 * 2022-04-22 (장민주) findAll 메소드 작성
 * 2022-04-23 (장민주) findAllProjectReport 메소드 작성
 * 2022-04-24 (장민주) findByProjectReportNo 메소드 작성
 * 2022-04-27 (장민주) findByProjectNo 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectReportMainRepository extends JpaRepository<ProjectReport, Integer> {

    /**
     * findAll: 모든 프로젝트신고내역 목록조회용 메소드입니다.
     * @param pageable: 페이징에 필요한 정보를 담는 객체
     * @return 한 페이지에 담길 프로젝트신고목록 리스트
     */
    Page<ProjectReport> findAll(Pageable pageable);

//    /**
//     * findReportAndReply: 경어체로 설명
//     * @param first: 설명
//     * @param second:
//     * @param third:
//     * @return
//     * @author 장민주
//     */
//    @Query(value = "SELECT\n" +
//                    "       A.PROJECT_REPORT_NO\n" +
//                    "     , A.PROJECT_REPORT_DATE\n" +
//                    "     , A.PROJECT_REPORT_CONTENT\n" +
//                    "     , A.REPORT_REF_URL\n" +
//                    "     , A.REPORTER_PHONE\n" +
//                    "     , A.REPORTER_EMAIL\n" +
//                    "     , A.REPORTER_NAME\n" +
//                    "     , A.MEMBER_NO\n" +
//                    "     , A.FARMER_NO\n" +
//                    "     , A.PROJECT_NO\n" +
//                    "     , B.REPORT_CATEGORY_NO\n" +
//                    "     , B.REPORT_CATEGORY_NAME\n" +
//                    "  FROM TBL_PROJECT_REPORT A\n" +
//                    "  JOIN TBL_REPORT_CATEGORY B ON (A.PROJECT_REPORT_CATEGORY_NO = B.REPORT_CATEGORY_NO)"
//                    , nativeQuery = true)
//    List<Object> findReportAndReply();

    /**
     * findAllProjectReport: 모든 프로젝트 신고내역 데이터를 조회하기 위한 메소드입니다.
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

    /**
     * findByProjectNo: 프로젝트 신고번호로 프로젝트 신고 상세내용 데이터를 조회하기 위한 메소드입니다.
     * @param projectReportNo 프로젝트 신고번호
     * @return ProjectReport 해당하는 프로젝트 신고 상세내용
     */
    ProjectReport findByProjectReportNo(int projectReportNo);

    @Query(value = "SELECT A.PROJECT_REPORT_NO\n" +
            "     , A.PROJECT_REPORT_DATE\n" +
            "     , A.PROJECT_REPORT_CONTENT\n" +
            "     , A.REPORT_REF_URL\n" +
            "     , A.REPORTER_PHONE\n" +
            "     , A.REPORTER_EMAIL\n" +
            "     , A.REPORTER_NAME\n" +
            "     , A.MEMBER_NO\n" +
            "     , A.FARMER_NO\n" +
            "     , A.PROJECT_REPORT_CATEGORY_NO\n" +
            "     , A.PROJECT_NO\n" +
            "     , A.PROJECT_REPORT_STATUS\n" +
            "     , A.DELETE_YN\n" +
            "  FROM TBL_PROJECT_REPORT A\n" +
            "  JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO)\n" +
            " WHERE B.PROJECT_NO = :projectNo\n" +
            "   AND B.PROGRESS_STATUS = :progressStatus",
            nativeQuery = true)
    ProjectReport findByProjectNo(int projectNo, int progressStatus);
}
