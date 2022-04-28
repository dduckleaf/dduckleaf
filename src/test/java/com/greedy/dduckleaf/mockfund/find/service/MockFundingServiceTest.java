package com.greedy.dduckleaf.mockfund.find.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.find.repository.MockFundForFundingRepository;
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
class MockFundingServiceTest {

    @Autowired
    private MockFundingService mockFundingService;

    @Test
    public void initTest() {
        assertNotNull(mockFundingService);
    }

    @Test
    @DisplayName("모의펀딩 목록 조회 테스트")
    public void findByProgressStatusTest() {

        //given

        //when
        List<MockFundDTO> mockFundList = mockFundingService.findByProgressStatus();

        //then
        assertNotNull(mockFundList);
        mockFundList.forEach(System.out::println);
    }

}