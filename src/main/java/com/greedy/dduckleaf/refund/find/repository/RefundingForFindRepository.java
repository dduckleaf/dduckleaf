package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.refund.find.entity.Refunding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : RefundingForFindRepository
 * Comment : 환불 조회
 *
 * History
 * 2022-05-04 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RefundingForFindRepository extends JpaRepository<Refunding, Integer> {

    Page<Refunding> findByMemberNo(int memberNo, Pageable pageable);

    List<Refunding> findByProject_farmerNo(int memberNo);

    Page<Refunding> findByProject_projectNo(int projectNo, Pageable pageable);

    Page<Refunding> findByRefundingStatus_refundingStatusNameContaining(String status, Pageable pageable);
}
