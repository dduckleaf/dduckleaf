package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.ContextConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.SettlementChangeHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        BeanConfiguration.class
})
class SettlementChangeHistoryForRefundingExamineRepositoryTest {

    @Autowired
    private SettlementChangeHistoryForRefundingExamineRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    public void findAll_test() {

        //when
        List<SettlementChangeHistory> histories = repo.findAll();

        //then
        assertNotNull(histories);
        histories.forEach(System.out::println);
    }
}