package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.regist.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PaymentHistoryForFundingRepository
 * Comment :
 *
 * History
 * 2022-04-24 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
public interface PaymentHistoryForFundingRepository extends JpaRepository<PaymentHistory, Integer> {
}
