package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.entity.FundingInfo;
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
class FundingInfoForShippingRepositoryTest {

    @Autowired
    private FundingInfoForShippingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("프로젝트에 대한 펀딩 정보 조회")
    public void findFundingInfoByProjectProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfo> info = repo.findFundingInfoByProjectProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트에 대한 펀딩 정보 조회")
    public void findCompleteFundingInfoByProjectProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfo> info = repo.findCompleteFundingInfoByProjectProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트에 대한 펀딩 정보 조회")
    public void findDelayFundingInfoByProjectProjectNoTest() {

        //given
        int projectNo = 343;

        //when
        List<FundingInfo> info = repo.findDelayFundingInfoByProjectProjectNo(projectNo);

        //then
        assertNotNull(info);
        info.forEach(System.out::println);
    }

}