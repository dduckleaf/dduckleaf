package com.greedy.dduckleaf.admin.repository;

import com.greedy.dduckleaf.admin.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class: FundingInfoForAdminRepository
 * Comment : 관리자 전용 기능
 * History
 * 2022/05/10 (박상범) 처음 작성 / 월별 펀딩금 조회 관련 메소드 작성, 월별 성공 프로젝트 갯수 조회 관련 메소드 작성, 월별 실패 프로젝트 갯수 조회 관련 메소드 작성, 월별 회원 가입 횟수 조회 관련 메소드 작성, 월별 회원 탈퇴 횟수 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface FundingInfoForAdminRepository extends JpaRepository<FundingInfo, Integer> {

    @Query(value = "SELECT \n" +
            "              SUBSTR(DATE_SUB(NOW(), INTERVAL -(TIMESTAMPDIFF(MONTH, now(), (STR_TO_DATE(A.FUNDING_DATE , '%Y-%m-%d')))) MONTH),1,7) as td,\n" +
            "              SUM(a.FUNDING_AMOUNT + a.DONATE_AMOUNT) as amount \n" +
            "         from tbl_funding_info A\n" +
            "        group by td\n" +
            "        order by 1 desc limit 13 ", nativeQuery = true)
    List<Object[]> findTotalAmountByMonth();

    @Query(value = "SELECT  \n" +
            "              SUBSTR(DATE_SUB(NOW(), INTERVAL -(TIMESTAMPDIFF(MONTH, now(), (STR_TO_DATE(A.END_DATE , '%Y-%m-%d')))) MONTH),1,7) as td," +
            "              COUNT(*)\n" +
            "         FROM TBL_PROJECT A\n" +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS B ON (A.PROGRESS_STATUS = B.PROJECT_PROGRESS_STATUS_NO) \n" +
            "        WHERE B.PROJECT_PROGRESS_STATUS_NAME = '완료' \n" +
            "          AND A.ACHIEVEMENT_RATE >= 100 \n" +
            "        GROUP BY td \n" +
            "        order by 1 desc limit 13 ", nativeQuery = true)
    List<Object[]> findSuccessProjectAmountByMonth();

    @Query(value = "SELECT  \n" +
            "              SUBSTR(DATE_SUB(NOW(), INTERVAL -(TIMESTAMPDIFF(MONTH, now(), (STR_TO_DATE(A.END_DATE , '%Y-%m-%d')))) MONTH),1,7) as td," +
            "              COUNT(*)\n" +
            "         FROM TBL_PROJECT A\n" +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS B ON (A.PROGRESS_STATUS = B.PROJECT_PROGRESS_STATUS_NO) \n" +
            "        WHERE B.PROJECT_PROGRESS_STATUS_NAME = '완료'\n" +
            "          AND A.ACHIEVEMENT_RATE < 100\n" +
            "        GROUP BY td \n" +
            "        order by 1 desc limit 13 ", nativeQuery = true)
    List<Object[]> findFailedProjectAmountByMonth();

    @Query(value = "SELECT\n" +
            "               SUBSTR(DATE_SUB(NOW(), INTERVAL -(TIMESTAMPDIFF(MONTH, now(), (STR_TO_DATE(A.MEMBER_JOIN_DATE , '%Y-%m-%d')))) MONTH),1,7) as td," +
            "               COUNT(*)\n" +
            "         FROM TBL_MEMBER A\n" +
            "        GROUP BY td " +
            "        order by 1 desc limit 6 ", nativeQuery = true)
    List<Object[]> findRegistMemberAmountByMonth();

    @Query(value = "select \n" +
            "              SUBSTR(DATE_SUB(NOW(), INTERVAL -(TIMESTAMPDIFF(MONTH, now(), (STR_TO_DATE(a.WITHDRAW_DATE , '%Y-%m-%d')))) MONTH),1,7) as td,\n" +
            "              count(*)\n" +
            "         from tbl_member_withdraw a \n" +
            "        group by td \n" +
            "        order by 1 desc limit 6", nativeQuery = true)
    List<Object[]> findRemoveMemberAmountByMonth();

}
