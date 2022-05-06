package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.RefundingStatus;
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
public class RefundingStatusForSettlementRepositoryTests {

    @Autowired
    private RefundingStatusForSettlementRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("환불상태코드 조회 테스트")
    public void findByRefundingStatusName_test() {

        //given
        String name = "환불승인";

        //when
        RefundingStatus refundingStatus = repository.findByRefundingStatusName(name);

        //then
        assertNotNull(refundingStatus);
        System.out.println(refundingStatus.getRefundingStatusNo());
    }
}
