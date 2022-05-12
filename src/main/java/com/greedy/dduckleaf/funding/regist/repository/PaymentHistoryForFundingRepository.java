package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PaymentHistoryForFundingRepository
 * Comment : 펀딩 조회
 *
 * History
 * 2022-04-24 홍성원
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
public interface PaymentHistoryForFundingRepository extends JpaRepository<PaymentHistory, Integer> {
}
