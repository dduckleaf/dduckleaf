package com.greedy.dduckleaf.settlement.check.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementPaymentInfoForFarmerCheckRepositoryTests {

    @Autowired
    private SettlementPaymentInfoForFarmerCheckRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("회차별 정산금 지급내역번호로 회차별 정산금 지급내역 조회 테스트")
    public void findById_test() {

        //given
        int settlementPaymentInfoNo = 1;

        //when
        SettlementPaymentInfo settlementPaymentInfo = repository.findById(settlementPaymentInfoNo).get();

        //then
        assertNotNull(settlementPaymentInfo);
        System.out.println("settlementPaymentInfo = " + settlementPaymentInfo);
    }

    @Test
    @DisplayName("회차별 정산금 지급내역 '지급상태' 컬럼 상태 변경 테스트")
    public void updateTable_test() {

        //given
        int settlementPaymentInfoNo = 1;

        //when
        SettlementPaymentInfo settlementPaymentInfo = repository.findById(settlementPaymentInfoNo).get();
        settlementPaymentInfo.setFarmerSettlementCheckStatus("Y");

        //then
        System.out.println("settlementPaymentInfo = " + settlementPaymentInfo);
    }
}
