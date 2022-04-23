package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.MockFund;
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
class MockFundRepositoryTest {

    @Autowired
    private MockFundRepository mockFundRepository;

    @Test
    public void initTest() {
        assertNotNull(mockFundRepository);
    }

    @Test
    @DisplayName("모의펀딩 정보 조회")
    public void findMockFundTest() {

        //given
        int infoId = 1;

        //then
        MockFund info = mockFundRepository.findById(infoId).get();

        //when
        assertNotNull(info);
        System.out.println("info = " + info);
    }

}