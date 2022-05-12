package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RefundingObjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : RefundingObjectionRepository
 * Comment : 환불 이의신청
 *
 * History
 * 2022-05-08 홍성원
 * </pre>
 * @version 1.0.0
 * @author 홍성원
 */
public interface RefundingObjectionRepository extends JpaRepository<RefundingObjection, Integer> {

    @Query(value = "SELECT * FROM TBL_REFUND_OBJECTION A ORDER BY A.REFUND_OBJECTION_NO DESC LIMIT 1", nativeQuery = true)
    RefundingObjection findLastest();

    List<RefundingObjection> findByRefundingInfoNo(int refundingNo);
}
