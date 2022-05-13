package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.funding.dto.FundingByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.find.member.dto.FundingFindDetailInfoForMemberDTO;
import com.greedy.dduckleaf.funding.find.member.dto.FundingInfoByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.find.member.dto.ProjectManageFundingDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * Class : FundingServiceForFindTest
 * Comment : FundingServiceForFind 클래스에 작성된 메소드를 단위테스트하는 클래스입니다.
 *
 * History
 * 2022-04-25 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaRepository.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FundingServiceForFindTest {

    @Autowired
    private FundingServiceForFind service;

    @Test
    @DisplayName("FundingServiceForFind 의존성주입 테스트")
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    @DisplayName("MemberNo로 Funding List 조회 테스트")
    public void findFundingByMemberNo_test() {

        //given
        int memberNo = 5;
        Pageable pageable = PageRequest.of(1, 10);

        //when
        Page<FundingDTO> fundingList =  service.findFundingByMemberNo(memberNo, pageable);

        //then
        assertNotNull(fundingList);
        fundingList.forEach(System.out::println);
    }

    @Test
    @DisplayName("펀딩정보 조회 테스트")
    public void findFundingInfo_test() {

        //given
        int fundingInfoNo = 106;

        //when
        FundingFindDetailInfoForMemberDTO fundingDTO = service.findFundingInfo(fundingInfoNo);

        //then
        assertNotNull(fundingDTO);
        System.out.println("fundingDTO = " + fundingDTO);
    }

    @Test
    @DisplayName("관리자의 회원별 펀딩목록 조회 테스트")
    public void findfundingInfoByMemberForAdmin_test() {

        //given
        Pageable pageable = PageRequest.of(0, 20);

        //when
        Page<FundingInfoByMemberForAdminDTO> fundinginfos = service.findfundingInfoByMemberForAdmin(pageable);

        //then
        assertNotNull(fundinginfos);
        fundinginfos.forEach(System.out::println);
    }

    @Test
    @DisplayName("관리자의 회원별 펀딩내역 조회 테스트")
    public void findFundingInfoByMemberId_test() {

        //given
        Pageable pageable = PageRequest.of(0, 20);
        int memberNo = 7;

        //when
        Page<FundingByMemberForAdminDTO> fundings = service.findFundingInfoByMemberId(memberNo, pageable);

        //then
        assertNotNull(fundings);
        fundings.forEach(System.out::println);
    }

    @Test
    @DisplayName("관리자의 프로젝트별 펀딩내역 조회 테스트")
    public void findFundingInfoByProjectNo_test() {

        //given
        Pageable pageable = PageRequest.of(0, 20);
        int projectNo = 343;

        //when
        ProjectManageFundingDTO fundings = service.findFundingInfoByProjectNo(projectNo, pageable);

        //then
        assertNotNull(fundings);
        fundings.getFundingInfos().forEach(System.out::println);
    }
}