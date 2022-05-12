package com.greedy.dduckleaf.shippingmanagement.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.dto.FundingInfoDTO;
import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import com.greedy.dduckleaf.shippingmanagement.dto.RewardShippingStatusDTO;
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
class ShippingServiceTest {

    @Autowired
    private ShippingService shippingService;

    @Test
    public void initTest() {
        assertNotNull(shippingService);
    }

    @Test
    @DisplayName("회원의 프로젝트 정보 조회")
    public void findProjectListByMemberNoTest() {

        //given
        int memberNo = 5;

        //when
        List<ProjectDTO> projectList = shippingService.findProjectListByMemberNo(memberNo);

        //then
        assertNotNull(projectList);
        projectList.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("프로젝트 정보 조회")
    public void findNotProjectListByProjectNoTest() {
        
        //given
        int projectNo = 343;
        
        //when
        ProjectDTO project = shippingService.findProjectListByProjectNo(projectNo);
        
        //then
        assertNotNull(project);
        System.out.println("project = " + project);
    }

    @Test
    @DisplayName("프로젝트 정보 조회")
    public void findCompleteProjectListByProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        ProjectDTO project = shippingService.findCompleteProjectListByProjectNo(projectNo);

        //then
        assertNotNull(project);
        System.out.println("project = " + project);
    }

    @Test
    @DisplayName("프로젝트 정보 조회")
    public void findDelayProjectListByProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        ProjectDTO project = shippingService.findDelayProjectListByProjectNo(projectNo);

        //then
        assertNotNull(project);
        System.out.println("project = " + project);
    }

    @Test
    @DisplayName("미발송 리워드 정보 조회")
    public void findRewardNotShippingListByProjectNoTest() {

        //given
        int projectNo = 344;

        //when
        List<RewardShippingStatusDTO> shippingList = shippingService.findRewardNotShippingListByProjectNo(projectNo);

        //then
        assertNotNull(shippingList);
        shippingList.forEach(System.out::println);
    }

    @Test
    @DisplayName("발송완료 리워드 정보 조회")
    public void findRewardCompleteShippingListByProjectNoTest() {

        //given
        int projectNo = 344;

        //when
        List<RewardShippingStatusDTO> shippingList = shippingService.findRewardCompleteShippingListByProjectNo(projectNo);

        //then
        assertNotNull(shippingList);
        shippingList.forEach(System.out::println);
    }

    @Test
    @DisplayName("발송완료 리워드 정보 조회")
    public void findRewardDelayShippingListByProjectNoTest() {

        //given
        int projectNo = 344;

        //when
        List<RewardShippingStatusDTO> shippingList = shippingService.findRewardDelayShippingListByProjectNo(projectNo);

        //then
        assertNotNull(shippingList);
        shippingList.forEach(System.out::println);
    }

    @Test
    @DisplayName("펀딩 내역 조회")
    public void findFundingInfoByProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfoDTO> info = shippingService.findFundingInfoByProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

    @Test
    @DisplayName("펀딩 내역 조회")
    public void findCompleteFundingInfoByProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfoDTO> info = shippingService.findCompleteFundingInfoByProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

    @Test
    @DisplayName("펀딩 내역 조회")
    public void findDelayFundingInfoByProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfoDTO> info = shippingService.findDelayFundingInfoByProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

}