package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.shippingmanagement.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundingInfoForShippingRepository extends JpaRepository<FundingInfo, Integer> {

    List<FundingInfo> findFundingInfoByProjectProjectNo(int projectNo);

    List<FundingInfo> findCompleteFundingInfoByProjectProjectNo(int projectNo);

    List<FundingInfo> findDelayFundingInfoByProjectProjectNo(int projectNo);
}
