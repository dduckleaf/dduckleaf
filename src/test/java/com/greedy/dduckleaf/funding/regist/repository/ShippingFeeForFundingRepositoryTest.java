package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.regist.entity.ProjectShippingFee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes ={
        BeanConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class ShippingFeeForFundingRepositoryTest {

    @Autowired
    private ShippingFeeForFundingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void findProjectShippingFeeForFundingRegistByProjectNo_test() {
        ProjectShippingFee shippingFee = repo.findProjectShippingFeeForFundingRegistByProjectNo(1);
        assertNotNull(shippingFee);
        System.out.println("shippingFee = " + shippingFee);
    }
}