package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
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
class MockFundInfoRepositoryTest {

    @Autowired
    private MockFundInfoRepository mockFundInfoRepository;

    @Test
    public void initTest() {
        assertNotNull(mockFundInfoRepository);
    }

    @Test
    @DisplayName("모의펀딩 기본정보 조회")
    public void findMockFundInfoTest() {

        //given
        int infoId = 1;

        //then
        MockFundInfo info = mockFundInfoRepository.findById(infoId).get();

        //when
        assertNotNull(info);
        System.out.println("info = " + info);
    }

}