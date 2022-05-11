package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentHistory;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementPaymentHistoryForCalculateRepositoryTests {

    @Autowired
    private SettlementPaymentHistoryForCalculateRepository repository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void initTest() {
        assertNotNull(repository);
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("회차별 정산금 지급내역 히스토리에 새로운 행 추가 테스트")
    public void saveSettlementPaymentHistory_test() {

        //given
        SettlementPaymentInfo settlementPaymentInfo = entityManager.find(SettlementPaymentInfo.class, 33);

        SettlementPaymentHistory settlementPaymentHistory = new SettlementPaymentHistory();
        settlementPaymentHistory.setSettlementPaymentInfo(settlementPaymentInfo);
        settlementPaymentHistory.setSettlementPaymentHistoryDate(getDateAndTime());
        settlementPaymentHistory.setSettlementPaymentHistoryCategory("지급금액계산");
        settlementPaymentHistory.setSettlementStatus("확인요청중");

        //when & then
        assertDoesNotThrow(() -> repository.save(settlementPaymentHistory));
    }
}
