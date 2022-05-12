package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        SpringSecurityConfiguration.class
})
class SettlementChangeHistoryForRefundingFarmerExamineRepositoryTest {

    @Autowired
    private SettlementChangeHistoryForRefundingFarmerExamineRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }
}