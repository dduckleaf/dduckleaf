package com.greedy.dduckleaf.admin.repository;

import com.greedy.dduckleaf.admin.entity.FundingInfo;
import com.greedy.dduckleaf.config.*;
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
class FundingInfoForAdminRepositoryTest {

    @Autowired
    private FundingInfoForAdminRepository fundingInfoForAdminRepository;

    @Test
    public void initTest() {
        assertNotNull(fundingInfoForAdminRepository);
    }

    @Test
    @DisplayName("펀딩 내역 전체 조회")
    public void findAllFundingInfo() {

        //given

        //when
        List<FundingInfo> fundingInfoList = fundingInfoForAdminRepository.findAll();

        //then
        assertEquals(fundingInfoList.size(), 0);
    }

    @Test
    @DisplayName("월별 펀딩금 조회 테스트")
    public void totalFundingAmountTest() {

        //given

        //when
        List<Object[]> totalAmountList = fundingInfoForAdminRepository.findTotalAmountByMonth();

        //then
        for (int i =0; i < totalAmountList.size(); i++) {
            System.out.println(totalAmountList.get(i)[0]);
            System.out.println(totalAmountList.get(i)[1]);
        }
        assertNotEquals(totalAmountList.size(), 0);
    }

    @Test
    @DisplayName("월별 성공 프로젝트 갯수 조회 테스트")
    public void findSuccessProjectAmountTest() {

        //given

        //when
        List<Object[]> successProjectAmountList = fundingInfoForAdminRepository.findSuccessProjectAmountByMonth();

        //then
        for (int i = 0; i < successProjectAmountList.size(); i++) {
            System.out.println(successProjectAmountList.get(i)[0]);
            System.out.println(successProjectAmountList.get(i)[1]);
        }
        assertNotEquals(successProjectAmountList.size(), 0);
    }

    @Test
    @DisplayName("월별 실패 프로젝트 갯수 조회 테스트")
    public void findFailedProjectAmountTest() {

        //given

        //when
        List<Object[]> failedProjectAmountList = fundingInfoForAdminRepository.findFailedProjectAmountByMonth();

        //then
        for (int i = 0; i < failedProjectAmountList.size(); i++) {
            System.out.println(failedProjectAmountList.get(i)[0]);
            System.out.println(failedProjectAmountList.get(i)[1]);
        }
        assertNotEquals(failedProjectAmountList.size(), 0);
    }

    @Test
    @DisplayName("월별 회원 가입 횟수 조회 테스트")
    public void findRegistMemberAmountTest() {

        //given

        //when
        List<Object[]> registMemberAmountList = fundingInfoForAdminRepository.findRegistMemberAmountByMonth();

        //then
        for (int i = 0; i < registMemberAmountList.size(); i++){
            System.out.println(registMemberAmountList.get(i)[0]);
            System.out.println(registMemberAmountList.get(i)[1]);
        }
        assertNotEquals(registMemberAmountList.size(), 0);
    }

    @Test
    @DisplayName("월별 회원 탈퇴 횟수 조회 테스트")
    public void findRemoveMemberAmountTest() {

        //given

        //when
        List<Object[]> removeMemberAmountList = fundingInfoForAdminRepository.findRemoveMemberAmountByMonth();

        //then
        for (int i = 0; i < removeMemberAmountList.size(); i++){
            System.out.println(removeMemberAmountList.get(i)[0]);
            System.out.println(removeMemberAmountList.get(i)[1]);
        }
        assertNotEquals(removeMemberAmountList.size(), 0);
    }

}