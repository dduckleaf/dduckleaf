package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.MockFundReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockFundRewardRepository extends JpaRepository<MockFundReward, Integer> {
    MockFundReward findByMockFundMockFundNo(int mockFundNo);
}
