package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RefundingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : RefundingHistoryForFarmerExamineRepository
 * Comment :
 *
 * History
 * 2022-05-05 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RefundingHistoryForFarmerExamineRepository extends JpaRepository<RefundingHistory, Integer> {

    @Query(value = "SELECT * FROM TBL_REFUNDING_HISTORY A ORDER BY A.REFUNDING_HISTORY_NO DESC LIMIT 1", nativeQuery = true)
    RefundingHistory findLastest();

}
