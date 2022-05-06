package com.greedy.dduckleaf.settlement.calculate.repository;


import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.PaymentHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class PaymentHistoryForSettlementCalculateRepositoryTests {

    @Autowired
    private PaymentHistoryForSettlementCalculateRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("결제가 완료되고 펀딩신청을 취소하지 않은 모든 펀딩내역 조회 테스트")
    public void findAllByFundingInfo_Project_ProjectNoAndPaymentResultStatusAndFundingInfo_FundingStatus_test() {

        //given
        int projectNo = 1;
        String paymentResultStatus = "결제완료";
        String fundingStatus = "Y";

        //when
        List<PaymentHistory> paymentHistories = repository.
                findAllByPaymentResultStatusAndFundingInfo_Project_ProjectNoAndFundingInfo_FundingStatus
                        (paymentResultStatus, projectNo, fundingStatus);

        //then
        paymentHistories.forEach(paymentHistory -> {
            assertNotNull(paymentHistory);
            System.out.println("paymentHistory = " + paymentHistory);
        });
    }
}


