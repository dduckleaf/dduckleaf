package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.ProjectShippingFee;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("프로젝트 배송비 정보 조회 테스트")
    public void findProjectShippingFeeForFundingRegistByProjectNo_test() {

        //given
        int projectNo = 1;

        //when
        ProjectShippingFee shippingFee = repo.findProjectShippingFeeForFundingRegistByProjectNo(projectNo);

        //then
        assertNotNull(shippingFee);
        System.out.println("shippingFee = " + shippingFee);
    }
}