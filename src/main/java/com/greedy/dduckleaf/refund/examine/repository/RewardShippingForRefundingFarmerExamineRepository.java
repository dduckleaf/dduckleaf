package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RewardShipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : RewardShippingForRefundingFarmerExamineRepository
 * Comment : 환불 심사
 *
 * History
 * 2022-05-05 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RewardShippingForRefundingFarmerExamineRepository extends JpaRepository<RewardShipping, Integer> {

    RewardShipping findByFunding_fundingInfoNo(int fundingInfoNo);
}
