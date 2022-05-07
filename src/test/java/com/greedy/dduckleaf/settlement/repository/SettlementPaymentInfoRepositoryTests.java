//package com.greedy.dduckleaf.settlement.repository;
//
//import com.greedy.dduckleaf.config.BeanConfiguration;
//import com.greedy.dduckleaf.config.DduckleafApplication;
//import com.greedy.dduckleaf.config.JPAConfiguration;
//import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@ContextConfiguration(classes = {
//        DduckleafApplication.class,
//        com.greedy.dduckleaf.config.ContextConfiguration.class,
//        BeanConfiguration.class,
//        JPAConfiguration.class,
//        SpringSecurityConfiguration.class
//})
//public class SettlementPaymentInfoRepositoryTests {
//
//    @Autowired
//    private SettlementPaymentInfoRepository repository;
//
//    @Test
//    public void initTest() {
//        assertNotNull(repository);
//    }
//
//    @Test
//    @DisplayName("정산정보로 회차별 정산금 지급내역 조회")
//    public void findBySettlementInfo_SettlementInfoNo_test() {
//        //given
//        int settlementInfoNo = 1;
//
//        //when
//        List<SettlementPaymentInfo> settlementPaymentInfos = repository.findBySettlementInfo_SettlementInfoNo(settlementInfoNo);
//
//        //then
//        assertNotNull(settlementPaymentInfos);
//        settlementPaymentInfos.forEach(System.out::println);
//    }
//}

