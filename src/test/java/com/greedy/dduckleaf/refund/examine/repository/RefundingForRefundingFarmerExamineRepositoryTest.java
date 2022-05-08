package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.Refunding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class RefundingForRefundingFarmerExamineRepositoryTest {

    @Autowired
    private RefundingForRefundingFarmerExamineRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("전체 목록 조회 테스트")
    @Transactional
    public void findById_test() {
        //given
        int refundNo = 39;

        //when
        Refunding refunding = repo.findById(refundNo).get();
        
        //then
        assertNotNull(refunding);
        System.out.println("refunding = " + refunding);
    }
}