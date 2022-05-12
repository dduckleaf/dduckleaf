package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.refund.examine.entity.RefundObjectionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : RefundObjectionHistoryRepository
 * Comment : 환불 심사
 *
 * History
 * 2022-05-08 홍성원
 * </pre>
 * @version 1.0.0
 * @author 홍성원
 */
public interface RefundObjectionHistoryRepository extends JpaRepository<RefundObjectionHistory, Integer> {
}
