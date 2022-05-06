package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.RefundingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : RefundingStatusForSettlementRepository
 * Comment : RefundingStatus 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-05 (장민주) 처음 작성
 * 2022-05-05 (장민주) findByRefundingStatusName 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface RefundingStatusForSettlementRepository extends JpaRepository<RefundingStatus, Integer> {

    /**
     * findByRefundingStatusName: 환불상태코드를 조회하기 위한 메소드입니다.
     * @param name : 환불상태 카테고리 명
     * @return 환불상태코드
     * @author 장민주
     */
    RefundingStatus findByRefundingStatusName(String name);
}
