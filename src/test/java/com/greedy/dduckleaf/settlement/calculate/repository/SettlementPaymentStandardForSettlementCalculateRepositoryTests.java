package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentStandard;
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
public class SettlementPaymentStandardForSettlementCalculateRepositoryTests {

    @Autowired
    private SettlementPaymentStandardForSettlementCalculateRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("정산금 지급기준 조회 테스트")
    public void _test() {

        //given
        String standardName = "기본";

        //when
        List<SettlementPaymentStandard> settlementPaymentStandards = repository.findAllByStandardName(standardName);

        //then
        settlementPaymentStandards.forEach(settlementPaymentStandard -> {
            assertNotNull(settlementPaymentStandard);
        });
        settlementPaymentStandards.forEach(System.out::println);
    }
}
