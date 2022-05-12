package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.SettlementChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : SettlementChangeHistoryForRefundingExamineRepository
 * Comment : 환불 심사
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface SettlementChangeHistoryForRefundingExamineRepository extends JpaRepository<SettlementChangeHistory, Integer> {

}
