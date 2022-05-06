package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.RefundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : RefundingInfoForSettlementCalculateRepository
 * Comment : RefundingInfo 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-05 (장민주) 처음 작성
 * 2022-05-05 (장민주) findRefundingInfosForSettlement 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface RefundingInfoForSettlementCalculateRepository extends JpaRepository<RefundingInfo, Integer> {

    /**
     * findRefundingInfosForSettlement: 정산정보에 반영되어야할 환불내역 조회 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @param refundingStatusNo: 환불처리상태
     * @return 승인 완료된 환불내역 목록
     * @author 장민주
     */
    @Query(value = "SELECT\n" +
                   "       A.REFUNDING_INFO_NO\n" +
                   "     , A.REFUNDING_DATE\n" +
                   "     , A.REFUNDING_STATUS_NO\n" +
                   "     , A.PROJECT_NO\n" +
                   "     , A.REFUNDING_END_DATE\n" +
                   "     , B.END_DATE\n" +
                   "     , A.FUNDING_INFO_NO\n" +
                   "     , C.FUNDING_AMOUNT\n" +
                   "     , C.DONATE_AMOUNT\n" +
                   "  FROM TBL_REFUNDING A\n" +
                   "  JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO)\n" +
                   "  JOIN TBL_FUNDING_INFO C ON (A.FUNDING_INFO_NO = C.FUNDING_INFO_NO)\n" +
                   " WHERE A.PROJECT_NO = :projectNo\n" +
                   "  AND A.REFUNDING_STATUS_NO = :refundingStatusNo\n" +
                   "  AND STR_TO_DATE(A.REFUNDING_END_DATE, '%Y-%m-%d  %H:%i') > STR_TO_DATE(B.END_DATE, '%Y-%m-%d')",
            nativeQuery = true)
    List<RefundingInfo> findRefundingInfosForSettlement(int projectNo, int refundingStatusNo);
}
