package com.greedy.dduckleaf.mockfund.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundRewardDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
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
class MockFundServiceTest {

    @Autowired
    private MockFundService mockFundService;

    @Test
    public void initTest() {
        assertNotNull(mockFundService);
    }

    @Test
    @DisplayName("모의펀딩 기본정보 특정 코드 조회 테스트")
    public void findMockFundInfoByCodeTest() {

        //given
        int infoCode = 1;

        //when
        MockFundInfoDTO info = mockFundService.findMockFundInfoByCode(infoCode);

        //then
        System.out.println(info);
        assertNotNull(info);
    }

    @Test
    @DisplayName("리워드 카테고리 목록 조회 테스트")
    public void findRewardCategoryList() {

        //given

        //when
        List<RewardCategoryDTO> categoryList = mockFundService.findRewardCategoryList();

        //then
        assertNotNull(categoryList);
        System.out.println("categoryList = " + categoryList);
    }

    @Test
    @DisplayName("모의펀딩 정보 특정 코드 조회 테스트")
    public void findMockFundByCode() {

        //given
        int mockFundCode = 1;

        //when
        MockFundDTO mockFund = mockFundService.findMockFundByCode(mockFundCode);

        //then
        assertNotNull(mockFund);
        System.out.println("mockFund = " + mockFund);
    }

    @Test
    @DisplayName("모의펀딩 스토리 정보 특정 코드 조회 테스트")
    public void findStoryInfoByCode() {

        //given
        int infoCode = 1;

        //when
        MockFundInfoDTO info = mockFundService.findMockFundInfoByCode(infoCode);

        //then
        System.out.println(info);
        assertNotNull(info);
    }

    @Test
    @DisplayName("모의펀딩 리워드 정보 조회 테스트")
    public void findRewardByCode() {

        //given
        int rewardCode = 1;

        //when
        MockFundRewardDTO info = mockFundService.findRewardByCode(rewardCode);

        //then
        assertNotNull(info);
        System.out.println("info = " + info);
    }

    //assertDoesNotThrow(() ->이자리에 테스트하고싶은 메소드 호출 ));  update

}