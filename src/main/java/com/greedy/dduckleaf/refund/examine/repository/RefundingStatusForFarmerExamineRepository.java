package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RefundingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : RefundingStatusForFarmerExamineRepository
 * Comment :
 *
 * History
 * 2022-05-05 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RefundingStatusForFarmerExamineRepository extends JpaRepository<RefundingStatus, Integer> {

}
