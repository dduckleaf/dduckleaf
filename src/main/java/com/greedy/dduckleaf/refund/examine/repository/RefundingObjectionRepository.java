package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RefundingObjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RefundingObjectionRepository extends JpaRepository<RefundingObjection, Integer> {

    @Query(value = "SELECT * FROM TBL_REFUND_OBJECTION A ORDER BY A.REFUND_OBJECTION_NO DESC LIMIT 1", nativeQuery = true)
    RefundingObjection findLastest();
}
