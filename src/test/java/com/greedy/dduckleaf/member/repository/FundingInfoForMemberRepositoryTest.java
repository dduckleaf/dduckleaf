package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.member.entity.FundingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FundingInfoForMemberRepositoryTest {

    @Autowired
    private FundingInfoForMemberRepository fundingInfoForMemberRepository;

    @Test
    public void initTest() {
        assertNotNull(fundingInfoForMemberRepository);
    }

    @Test
    @DisplayName("회원의 펀딩 내역중에 진행중인 프로젝트가 있는지 조회")
    public void findFundingInfoTest() {

        //given
        int memberNo = 7;
        String projectProgressStatusName = "진행중";
        String projectStatus = "Y";

        //when
        List<FundingInfo> fundingList = fundingInfoForMemberRepository.findByProject_projectProgressStatus_projectProgressStatusNameAndProject_projectStatusAndMember_memberNo(projectProgressStatusName,projectStatus,memberNo);

        //then
        fundingList.forEach(System.out::println);
        assertNotEquals(fundingList.size(), 0);
    }
}