package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class RewardRegistInfoRepositoryTest {

    @Autowired
    private RewardRegistInfoRepository rewardRegistInfoRepository;

    @Test
    public void initTest() {

        assertNotNull(rewardRegistInfoRepository);
    }




}