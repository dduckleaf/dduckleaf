package com.greedy.dduckleaf.mockfund.find.repository;

import com.greedy.dduckleaf.mockfund.entity.MockFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockFundForFundingRepository extends JpaRepository<MockFund, Integer> {

    List<MockFund> findByMockFundProgressStatus(String 진행전);
}
