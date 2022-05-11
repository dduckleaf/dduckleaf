package com.greedy.dduckleaf.settlement.check.repository;

import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : SettlementPaymentHistoryForCalculateRepository
 * Comment : SettlementPaymentHistory 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-11 (장민주) 처음 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface SettlementPaymentHistoryForFarmerCheckRepository extends JpaRepository<SettlementPaymentHistory, Integer> {
}
