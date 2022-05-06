package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : PaymentHistoryForSettlementCalculateRepository
 * Comment : PaymentHistory 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-05 (장민주) 처음 작성
 * 2022-05-05 (장민주) findAllByFundingInfo_Project_ProjectNoAndPaymentResultStatusAndFundingInfo_FundingStatus 쿼리메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface PaymentHistoryForSettlementCalculateRepository extends JpaRepository<PaymentHistory, Integer> {

    /**
     * findAllByFundingInfo_Project_ProjectNoAndPaymentResultStatusAndFundingInfo_FundingStatus:
     * 결제가 완료되고 펀딩신청을 취소하지 않은 모든 펀딩내역 조회를 요청하는 메소드입니다.
     * @param paymentResultStatus: 결제처리상태
     * @param projectNo: 프로젝트번호
     * @param fundingStatus: 펀딩 취소여부
     * @return 프로젝트 결제 이력 목록
     * @author 장민주
     */
    List<PaymentHistory> findAllByPaymentResultStatusAndFundingInfo_Project_ProjectNoAndFundingInfo_FundingStatus(String paymentResultStatus, int projectNo, String fundingStatus);
}
