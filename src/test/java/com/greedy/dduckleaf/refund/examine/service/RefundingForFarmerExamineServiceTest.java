package com.greedy.dduckleaf.refund.examine.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.dto.FundingDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingObjectionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

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
        int memberNo = 5;

        //when & then
        assertDoesNotThrow(() -> service.confirmRefunding(refundNo, memberNo));
    }

    @Test
    public void findObjections_test() {

        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("refundObjectionNo").descending());

        //when
        Page<RefundingObjectionDTO> objections = service.findObjectionList(pageable);

        //then
        assertNotNull(objections);
        objections.forEach(System.out::println);
    }

    @Test
    public void registObjection_test() {

        //given
        int refundingNo = 39;

        //when & then
        assertDoesNotThrow(() -> service.registObjection(refundingNo));
    }
}