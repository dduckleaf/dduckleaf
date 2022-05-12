package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.dto.BankDTO;
import com.greedy.dduckleaf.funding.dto.FundingRegistInfoDTO;
import com.greedy.dduckleaf.funding.dto.MemberDTO;
import com.greedy.dduckleaf.funding.dto.ProjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class FundingRegistServiceTest {

    @Autowired
    private FundingRegistService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

    @Test
    @DisplayName("한 프로젝트의 펀딩등록 시 필요 정보 조회 테스트")
    public void findProjectInfoById_test() {
        int projectNo = 1;

        ProjectDTO projectInfoDTO = service.findProjectFundingInfo(projectNo);
        
        assertNotNull(projectInfoDTO);
        System.out.println("projectInfoDTO = " + projectInfoDTO);
    }

    @Test
    @DisplayName("은행목록과 회원정보 조회 테스트")
    public void findBankAndUserInfo_test() {

        //given
        String memberId = "USER01";
        int projectNo = 1;
        //when
        FundingRegistInfoDTO fundingRegistInfo = service.findBankAndUserInfo(memberId, projectNo);
        List<BankDTO> bankList = fundingRegistInfo.getBankList();
        MemberDTO member = fundingRegistInfo.getMember();

        //then
        assertNotNull(fundingRegistInfo);
        assertNotNull(bankList);
        assertNotNull(member);

        bankList.forEach(System.out::println);
        System.out.println("member = " + member);
    }
}