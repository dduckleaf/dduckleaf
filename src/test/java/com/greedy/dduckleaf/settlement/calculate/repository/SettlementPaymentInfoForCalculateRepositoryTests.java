package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentInfo;
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
public class SettlementPaymentInfoForCalculateRepositoryTests {

    @Autowired
    private SettlementPaymentInfoForCalculateRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("정산정보로 회차별 정산금 지급내역 조회: 존재하는 경우")
    public void findBySettlementInfo_SettlementInfoNo_isExist_test() {

        //given
        int settlementInfoNo = 25;

        //when
        List<SettlementPaymentInfo> settlementPaymentInfos =
                repository.findBySettlementInfo_SettlementInfoNo(settlementInfoNo);

        //then
        settlementPaymentInfos.forEach(settlementPaymentInfo -> {
            assertNotNull(settlementPaymentInfo);
            System.out.println("settlementPaymentInfo = " + settlementPaymentInfo);
        });
    }

    @Test
    @DisplayName("정산정보로 회차별 정산금 지급내역 조회: 존재하지 않는 경우")
    public void findBySettlementInfo_SettlementInfoNo_isEmpty_test() {

        //given
        int settlementInfoNo = 25;

        //when
        List<SettlementPaymentInfo> settlementPaymentInfos =
                repository.findBySettlementInfo_SettlementInfoNo(settlementInfoNo);

        //then
        settlementPaymentInfos.forEach(settlementPaymentInfo -> {
            assertNull(settlementPaymentInfo);
        });
    }
}

