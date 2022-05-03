package com.greedy.dduckleaf.refund.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.regist.entity.Funding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FundingForRefundingRegistRepositoryTest {

    @Autowired
    private FundingForRefundingRegistRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("펀딩내역 조회 테스트")
    public void findById_test() {

        //given
        int fundingInfoNo = 103;

        //when
        Funding funding = repo.findById(fundingInfoNo).get();

        //then
        assertNotNull(funding);
        System.out.println("funding = " + funding);
    }
}