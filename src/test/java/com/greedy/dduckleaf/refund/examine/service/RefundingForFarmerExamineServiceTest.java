package com.greedy.dduckleaf.refund.examine.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.dto.FundingDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class RefundingForFarmerExamineServiceTest {

    @Autowired
    private RefundingForFarmerExamineService service;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    public void confirmRefunding_test() {

        //given
        int refundNo = 33;

        //when & then
        assertDoesNotThrow(() -> service.confirmRefunding(refundNo));
    }
}