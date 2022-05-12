package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.entity.RewardShipping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
class RewardShippingForShippingRepositoryTest {

    @Autowired
    private RewardShippingForShippingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("프로젝트 정보 조회")
    public void findByProjectProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<RewardShipping> shipping = repo.findByProjectProjectNo(projectNo);

        //then
        assertNotNull(shipping);
        shipping.forEach(System.out::println);
    }

}