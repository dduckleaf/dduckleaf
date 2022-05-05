package com.greedy.dduckleaf.mockfund.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundRewardDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
import com.greedy.dduckleaf.mockfund.entity.Farmer;
import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
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
        MockFundInfoDTO info = mockFundService.findMockFundInfoByMockFundNo(infoCode);

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
        MockFundInfoDTO info = mockFundService.findMockFundInfoByMockFundNo(infoCode);

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
        MockFundRewardDTO info = mockFundService.findRewardByMockFundNo(rewardCode);

        //then
        assertNotNull(info);
        System.out.println("info = " + info);
    }

    //assertDoesNotThrow(() ->이자리에 테스트하고싶은 메소드 호출 ));  update

    @Test
    @DisplayName("모의펀딩 기본정보 업데이트 테스트")
    @Transactional
    public void modifyBasicInfo() {

        //given
        MockFundInfoDTO infoList = new MockFundInfoDTO();
        RewardCategoryDTO reward = new RewardCategoryDTO();
        infoList.setMockFundName("프로젝트");
        infoList.setTargetTicketAmount(100);
        reward.setProjectCategoryNo(1);
        infoList.setRewardCategory(reward);

        //when & then
        assertDoesNotThrow(() -> mockFundService.modifyBasicInfo(infoList));
    }

    @Test
    @DisplayName("모의펀딩 스토리 업데이트 테스트")
    @Transactional
    public void modifyStory() {

        //given
        MockFundInfoDTO infoList = new MockFundInfoDTO();
        infoList.setMockFundDetail("프로젝트 요약");
        infoList.setMockFundAgreementStatus("Y");

        //when & then
        assertDoesNotThrow(() -> mockFundService.modifyStory(infoList));
    }

    @Test
    @DisplayName("모의펀딩 리워드 정보 업데이트 테스트")
    @Transactional
    public void modifyReward() {

        //given
        MockFundRewardDTO reward = new MockFundRewardDTO();
        reward.setRewardName("리워드 이름");
        reward.setRewardDetail("리워드 요약");
        reward.setRewardPrice(10000);

        //when & then
        assertDoesNotThrow(() -> mockFundService.modifyReward(reward));
    }

    @Test
    @DisplayName("모의펀딩 스토리 동의 체크 테스트")
    public void modifyAgreementStatus() {
        
        //given
        int infoCode = 1;
        String status = "Y";
        
        //when
        MockFundInfoDTO info = mockFundService.findMockFundInfoByMockFundNo(infoCode);
        
        //then
        assertNotNull(info);
        info.setMockFundAgreementStatus(status);
        System.out.println("info = " + info);
    }



}