package com.greedy.dduckleaf.myfunding.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.myfunding.entity.FundingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.management.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FundingInfoForMyFundingRepositoryTest {

    @Autowired
    private FundingInfoForMyFundingRepository fundingInfoForMyFundingRepository;

    @Test
    public void initTest() {
        assertNotNull(fundingInfoForMyFundingRepository);
    }

    @Test
    @DisplayName("회원번호로 진행중인 펀딩 내역 조회")
    public void findFundingByMemberNoAndProjectProgressStatusTest() {

        //given
        int memberNo = 5;

        //when
        List<FundingInfo> fundingInfoList = fundingInfoForMyFundingRepository.findFundingByMemberNoAndProjectProgressStatus(memberNo);

        //then
        assertNotNull(fundingInfoList);
        fundingInfoList.forEach(System.out::println);
    }
}