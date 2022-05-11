package com.greedy.dduckleaf.settlement.check.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentHistory;
import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementCheckServiceTests {

    @Autowired
    private SettlementCheckService service;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void initTest() {
        assertNotNull(service);
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("파머의 정산정보 확인여부 update 성공 테스트")
    public void modifySettlementPaymentInfo_success_test() {

        //given
        int settlementPaymentInfoNo = 1;

        //when
        String modifyResult = service.modifySettlementPaymentInfo(settlementPaymentInfoNo);

        //then
        assertEquals("Y", entityManager.find(SettlementPaymentInfo.class, 1).getFarmerSettlementCheckStatus());
        assertEquals("확인 접수가 완료되었습니다.", modifyResult);
    }

    @Test
    @DisplayName("파머의 정산정보 확인여부 update 실패 테스트")
    public void modifySettlementPaymentInfo_fail_test() {

        //given
        int settlementPaymentInfoNo = 1;

        //when
        String modifyResult = service.modifySettlementPaymentInfo(settlementPaymentInfoNo);

        //then
        assertEquals("N", entityManager.find(SettlementPaymentInfo.class, 1).getFarmerSettlementCheckStatus());
        assertEquals("확인 접수에 실패하였습니다.", modifyResult);
    }

    @Test
    @DisplayName("내부연산 메소드: 회차별 정산금 지급내역 히스토리에 새로운 행을 추가 요청 테스트")
    public void saveSettlementPaymentHistory_success_test() {

        //given
        SettlementPaymentInfo settlementPaymentInfo = entityManager.find(SettlementPaymentInfo.class, 32);

        //when & then
        assertDoesNotThrow(() -> service.saveSettlementPaymentHistory(settlementPaymentInfo));
    }
}
