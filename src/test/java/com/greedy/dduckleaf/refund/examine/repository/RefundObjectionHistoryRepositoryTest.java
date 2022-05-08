package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.ContextConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.RefundObjectionHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        ContextConfiguration.class
})
class RefundObjectionHistoryRepositoryTest {

    @Autowired
    private RefundObjectionHistoryRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("최신 삽입 내역 조회 테스트")
    public void findAll_test() {

        //when
        List<RefundObjectionHistory> refundObjectionHistories = repo.findAll();

        //then
        assertNotNull(refundObjectionHistories);
        refundObjectionHistories.forEach(System.out::println);
    }
}