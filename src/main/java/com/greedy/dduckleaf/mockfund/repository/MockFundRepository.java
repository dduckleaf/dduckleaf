package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.MockFund;
import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockFundRepository extends JpaRepository<MockFund, Integer> {


}