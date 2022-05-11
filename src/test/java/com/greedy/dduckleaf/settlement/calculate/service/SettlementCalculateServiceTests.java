package com.greedy.dduckleaf.settlement.calculate.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.dto.FundingInfoDTO;
import com.greedy.dduckleaf.settlement.calculate.dto.ProjectApplyFeeInfoDTO;
import com.greedy.dduckleaf.settlement.calculate.dto.RefundingInfoDTO;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementInfo;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementCalculateServiceTests {

    @Autowired
    private SettlementCalculateService service;

    @Test
    public void initTest() { assertNotNull(service); }

//    @Test
//    @DisplayName("내부연산메소드: 프로젝트 적용 수수료율 조회 테스트")
//    public void getFeeApplyRateForProject_test() {
//
//        //given
//        int projectNo = 1;
//
//        //when
//        ProjectApplyFeeInfoDTO feeApplyRate = service.getFeeApplyRateForProject(projectNo);
//
//        //then
//        System.out.println("feeApplyRate = " + feeApplyRate);
//    }

//    @Test
//    @DisplayName("내부연산메소드: 프로젝트의 결제이력 조회 테스트")
//    public void findPaymentHistoriesForProject_test() {
//
//        //given
//        int projectNo = 1;
//
//        //when
//        List<FundingInfoDTO> fundingInfos = service.getPaymentHistoriesForProject(projectNo);
//
//        //then
//        fundingInfos.forEach(fundingInfo -> {
//            assertNotNull(fundingInfo);
//            System.out.println("fundingInfo = " + fundingInfo);
//        });
//    }

//    @Test
//    @DisplayName("내부연산메소드: 환불승인번호 조회 테스트")
//    public void getRefundingStatusNo_test() {
//        
//        //when
//        int refundingStatusNo = service.getRefundingStatusNo();
//        
//        //then
//        assertNotNull(refundingStatusNo);
//        System.out.println("refundingStatusNo = " + refundingStatusNo);
//    }

//    @Test
//    @DisplayName("내부연산메소드: 프로젝트 환불내역 조회 테스트")
//    public void findRefundingInfosForProject_test() {
//
//        //given
//        int projectNo = 1;
//
//        //when
//        List<RefundingInfoDTO> refundingInfos = service.findRefundingInfosForProject(projectNo);
//
//        //then
//        System.out.println("list size = " + refundingInfos.size());
//        refundingInfos.forEach(refundingInfo -> {
//            assertNotNull(refundingInfo);
//            System.out.println("refundingInfo = " + refundingInfo);
//        });
//    }

//    @Test
//    @DisplayName("프로젝트 정산금 계산 테스트")
//    public void calculateSettlementForProject_test() {
//
//        //given
//        int projectNo = 1;
//
//        //when
//        SettlementInfo settlementInfo = service.calculateSettlementForProject(projectNo);
//
//        //then
//        assertNotNull(settlementInfo);
//        System.out.println("settlementInfo = " + settlementInfo);
//    }

    @Test
    @DisplayName("프로젝트 정산정보 등록 테스트")
    public void registSettlementInfo_test() {

        //given
        int projectNo = 1;

        //when
        service.registSettlementInfo(projectNo);

        //then
        assertDoesNotThrow(() -> service.registSettlementInfo(projectNo));
    }

//    @Test
//    @DisplayName("회차별 정산금 지급내역 계산 및 등록 성공 테스트")
//    public void calculateSettlementForEachPaymentRound_test() {
//
//        //given
//        int projectNo = 1;
//
//        //when & then
//        assertDoesNotThrow(() -> service.calculateSettlementForEachPaymentRound(projectNo));
//    }

    @Test
    @DisplayName("")
    public void registOrModifySettlementPaymentInfo_test() {

        //given
        int projectNo = 345;

        //when & then
        assertDoesNotThrow(() -> service.registOrModifySettlementPaymentInfo(projectNo));
    }
}
