package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.refund.find.entity.Refunding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : RefundingForFindRepository
 * Comment :
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
}