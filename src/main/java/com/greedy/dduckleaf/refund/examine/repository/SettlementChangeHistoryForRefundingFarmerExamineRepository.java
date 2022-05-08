package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.SettlementChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementChangeHistoryForRefundingFarmerExamineRepository extends JpaRepository<SettlementChangeHistory, Integer> {

}
