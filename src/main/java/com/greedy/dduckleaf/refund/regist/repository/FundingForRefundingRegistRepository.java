package com.greedy.dduckleaf.refund.regist.repository;

import com.greedy.dduckleaf.refund.regist.entity.Funding;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : FundingForRefundingRegistRepository
 * Comment : 환불 등록
 *
 * History
 * 2022-05-03 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface FundingForRefundingRegistRepository extends JpaRepository<Funding, Integer> {

}
