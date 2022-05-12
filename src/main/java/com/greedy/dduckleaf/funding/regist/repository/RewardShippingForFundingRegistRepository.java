package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.RewardShipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : RewardShippingForFundingRegistRepository
 * Comment : 펀딩조회
 *
 * History
 * 2022-05-05 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RewardShippingForFundingRegistRepository extends JpaRepository<RewardShipping, Integer> {

    @Query(value = "SELECT * FROM TBL_REWARD_SHIPPING A ORDER BY A.REWARD_SHIPPING_NO DESC LIMIT 1", nativeQuery = true)
    RewardShipping findLatest();
}
