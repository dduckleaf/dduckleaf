package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.RewardShipping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class RewardShippingForRefundingFarmerExamineRepositoryTest {

    @Autowired
    private RewardShippingForRefundingFarmerExamineRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }
    
    @Test
    public void findByFunding_fundingInfoNo_test() {

        //given
        int fundingInfoNo = 115;
        
        //when
        RewardShipping shipping = repo.findByFunding_fundingInfoNo(fundingInfoNo);
        
        //then
        assertNotNull(shipping);
        System.out.println("shipping = " + shipping);
    }
}