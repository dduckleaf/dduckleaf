package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.MockFund;
import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockFundRepository extends JpaRepository<MockFund, Integer> {

    @Query(value = "SELECT * FROM TBL_MOCK_FUND M WHERE M.FARMER_NO = :farmerNo AND M.MOCK_FUND_PROGRESS_STATUS = :s ORDER BY M.MOCK_FUND_NO DESC LIMIT 1", nativeQuery = true)
    MockFund findByFarmerNoAndAndProgressStatus(int farmerNo, String s);
}
