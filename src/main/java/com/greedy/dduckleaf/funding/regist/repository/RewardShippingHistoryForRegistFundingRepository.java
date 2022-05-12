package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.RewardShippingHistory;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : RewardShippingHistoryForRegistFundingRepository
 * Comment : 펀딩 조회
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RewardShippingHistoryForRegistFundingRepository extends JpaRepository<RewardShippingHistory, Integer> {
}
