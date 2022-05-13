package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.Refunding;
import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundingForFundingRefundingRepository extends JpaRepository<Refunding, Integer> {

    Page<RefundingDTO> findByProject_projectNo(int projectNo, Pageable pageable);
}
