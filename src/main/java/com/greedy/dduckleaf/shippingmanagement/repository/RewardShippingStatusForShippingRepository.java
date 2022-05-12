package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.shippingmanagement.entity.RewardShipping;
import com.greedy.dduckleaf.shippingmanagement.entity.RewardShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardShippingStatusForShippingRepository extends JpaRepository<RewardShippingStatus, Integer> {

    RewardShippingStatus findByFundingInfoFundingInfoNo(int fundingInfoNo);

    @Query(value = "SELECT * FROM TBL_REWARD_SHIPPING R WHERE R.PROJECT_NO = :projectNo AND R.SHIPPING_STATUS_NO = :i ORDER BY R.REWARD_SHIPPING_NO", nativeQuery = true)
    List<RewardShippingStatus> findNotRewardListByProjectProjectNoAndAndShippingStatusNo(int projectNo, int i);

    @Query(value = "SELECT * FROM TBL_REWARD_SHIPPING R WHERE R.PROJECT_NO = :projectNo AND R.SHIPPING_STATUS_NO = :i ORDER BY R.REWARD_SHIPPING_NO", nativeQuery = true)
    List<RewardShippingStatus> findCompleteRewardListByProjectProjectNoAndAndShippingStatusNo(int projectNo, int i);

    @Query(value = "SELECT * FROM TBL_REWARD_SHIPPING R WHERE R.PROJECT_NO = :projectNo AND R.SHIPPING_STATUS_NO = :i ORDER BY R.REWARD_SHIPPING_NO", nativeQuery = true)
    List<RewardShippingStatus> findDelayRewardListByProjectProjectNoAndAndShippingStatusNo(int projectNo, int i);
}
