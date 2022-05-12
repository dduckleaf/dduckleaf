package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.entity.RewardShippingStatus;
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
class RewardShippingStatusForShippingRepositoryTest {

    @Autowired
    private RewardShippingStatusForShippingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }
    
    @Test
    @DisplayName("펀딩 정보 조회")
    public void findByFundingInfoFundingInfoNoTest() {
        
        //given
        int fundingInfoNo = 162;
        
        //when
        RewardShippingStatus status = repo.findByFundingInfoFundingInfoNo(fundingInfoNo);
        
        //then
        assertNotNull(status);
        System.out.println("status = " + status);
    }

    @Test
    @DisplayName("미발송 리워드 정보 조회")
    public void findNotRewardListByProjectProjectNoAndAndShippingStatusNoTest() {

        //given
        int projectNo = 343;
        int statusNo = 1;

        //when
        List<RewardShippingStatus> status = repo.findNotRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, statusNo);

        //then
        assertNotNull(status);
        status.forEach(System.out::println);
    }

    @Test
    @DisplayName("발송완료 리워드 정보 조회")
    public void findCompleteRewardListByProjectProjectNoAndAndShippingStatusNoTest() {

        //given
        int projectNo = 343;
        int statusNo = 2;

        //when
        List<RewardShippingStatus> status = repo.findCompleteRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, statusNo);

        //then
        assertNotNull(status);
        status.forEach(System.out::println);
    }

    @Test
    @DisplayName("발송지연 리워드 정보 조회")
    public void findDelayRewardListByProjectProjectNoAndAndShippingStatusNoTest() {

        //given
        int projectNo = 343;
        int statusNo = 3;

        //when
        List<RewardShippingStatus> status = repo.findDelayRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, statusNo);

        //then
        assertNotNull(status);
        status.forEach(System.out::println);
    }

}