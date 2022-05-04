package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PaymentHistoryForFundingFindMember
 * Comment :
 *
 * History
 * 2022-05-02 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface PaymentHistoryForFundingFindMemberRepository extends JpaRepository<PaymentHistory, Integer> {

    PaymentHistory findByFunding_fundingInfoNo(int fundingNo);
}
