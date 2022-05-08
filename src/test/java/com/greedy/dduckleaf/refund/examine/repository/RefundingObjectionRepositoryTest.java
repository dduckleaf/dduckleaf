package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.ContextConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.RefundingObjection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        JPAConfiguration.class,
        ContextConfiguration.class,
        BeanConfiguration.class
})
class RefundingObjectionRepositoryTest {

    @Autowired
    private RefundingObjectionRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("전체 목록 조회 테스트")
    public void findAll_test() {

        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("refundObjectionNo").descending());

        //when
        Page<RefundingObjection> objections = repo.findAll(pageable);

        //then
        assertNotNull(objections);
        objections.forEach(System.out::println);
    }

    @Test
    @DisplayName("최신 삽입 내역 조회 테스트")
    public void findLastest_test() {

        //when
        RefundingObjection lastestOne = repo.findLastest();

        //then
        assertNotNull(lastestOne);
        System.out.println("lastestOne = " + lastestOne);


    }
}