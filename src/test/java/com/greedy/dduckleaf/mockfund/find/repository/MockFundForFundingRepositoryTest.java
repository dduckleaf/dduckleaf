package com.greedy.dduckleaf.mockfund.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.MockFund;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class MockFundForFundingRepositoryTest {

    @Autowired
    private MockFundForFundingRepository fundingRepository;

    @Test
    public void initTest() {
        assertNotNull(fundingRepository);
    }

    @Test
    @DisplayName("모의펀딩 목록 조회")
    public void findMockFundingListTest() {

        //given
        String status = "진행전";

        //when
        List<MockFund> mockFundList = fundingRepository.findByMockFundProgressStatus(status);

        //then
        assertNotNull(mockFundList);
        mockFundList.forEach(mockFund -> {
            System.out.println("mockFund = " + mockFund);
        });
    }
    
    @Test
    @DisplayName("모의펀딩 상세 조회")
    public void findMockFundingDetailTest() {
        
        //given
        int mockFundNo = 1;
        
        //when
        MockFund mockFund = fundingRepository.findById(mockFundNo).get();
        
        //then
        assertNotNull(mockFund);
        System.out.println("mockFund = " + mockFund);
    }

}