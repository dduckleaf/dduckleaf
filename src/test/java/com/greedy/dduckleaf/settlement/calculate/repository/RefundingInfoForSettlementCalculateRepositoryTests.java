package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.RefundingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class RefundingInfoForSettlementCalculateRepositoryTests {

    @Autowired
    private RefundingInfoForSettlementCalculateRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("정산정보에 반영되어야할 환불내역 조회 테스트")
    public void findRefundingInfosForSettlement_test() {

        //given
        int projectNo = 1;
        int refundingStatusNo = 2;

        //when
        List<RefundingInfo> refundingInfos = repository.findRefundingInfosForSettlement(projectNo, refundingStatusNo);

        //then
        refundingInfos.forEach(refundingInfo -> {
            assertNotNull(refundingInfo);
            System.out.println("refundingInfo = " + refundingInfo);
        });
    }

    @Test
    @DisplayName("정산정보에 반영되어야할 환불내역 조회 테스트: 환불내역이 존재하지 않는 경우")
    public void findRefundingInfosForSettlement_notExist_test() {

        //given
        int projectNo = 6;
        int refundingStatusNo = 2;

        //when
        List<RefundingInfo> refundingInfos = repository.findRefundingInfosForSettlement(projectNo, refundingStatusNo);

        //then
        refundingInfos.forEach(refundingInfo -> {
            assertNull(refundingInfo);
        });
    }
}
