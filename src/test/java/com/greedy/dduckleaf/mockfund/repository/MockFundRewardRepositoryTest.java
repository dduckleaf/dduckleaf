package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.MockFundReward;
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
class MockFundRewardRepositoryTest {

    @Autowired
    private MockFundRewardRepository mockFundRewardRepository;

    @Test
    public void initTest() {
        assertNotNull(mockFundRewardRepository);
    }

    @Test
    @DisplayName("모의펀딩 리워드 정보 조회")
    public void findMockFundRewardTest() {

        //given
        int infoId = 1;

        //then
        MockFundReward info = mockFundRewardRepository.findById(infoId).get();

        //when
        assertNotNull(info);
        System.out.println("info = " + info);
    }

}