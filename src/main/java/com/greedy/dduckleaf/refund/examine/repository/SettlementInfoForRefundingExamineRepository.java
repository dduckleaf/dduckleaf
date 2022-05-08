package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.SettlementInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementInfoForRefundingExamineRepository extends JpaRepository<SettlementInfo, Integer> {

    SettlementInfo findByProjectNo(int projectNo);
}
