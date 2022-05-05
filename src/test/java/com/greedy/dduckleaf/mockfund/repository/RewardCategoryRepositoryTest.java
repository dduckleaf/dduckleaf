package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.RewardCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class RewardCategoryRepositoryTest {

    @Autowired
    private RewardCategoryRepository rewardCategoryRepository;

    @Test
    public void initTest() {
        assertNotNull(rewardCategoryRepository);
    }

    @Test
    @DisplayName("리워드 카테고리 목록 정보 조회")
    public void findRewardCategoryTest() {

        //given
        int infoId = 1;

        //then
        RewardCategory info = rewardCategoryRepository.findById(infoId).get();

        //when
        assertNotNull(info);
        System.out.println("info = " + info);
    }

}