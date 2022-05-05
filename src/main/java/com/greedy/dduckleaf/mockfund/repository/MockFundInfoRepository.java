package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockFundInfoRepository extends JpaRepository<MockFundInfo, Integer> {

    MockFundInfo findByMockFundMockFundNo(int mockFundNo);
}
