package com.greedy.dduckleaf.refund.find.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class RefundingForFindServiceTest {

    @Autowired
    private RefundingForFindService service;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    public void findRefundingListForMember_test() {
        //given
        int memberNo = 3;
        Pageable pageable = PageRequest.of(0, 10);

        //when
        Page<RefundingDTO> refundings = service.findRefundingListForMember(memberNo, pageable);

        //then
        assertNotNull(service);
        refundings.forEach(System.out::println);
    }

    @Test
    public void findRefundingInfo_test() {

        //given
        int refundNo = 31;

        //when
        RefundingDTO refundingDTO = service.findRefundingInfo(refundNo);

        //then
        assertNotNull(refundingDTO);
        System.out.println("refundingDTO = " + refundingDTO);
    }
}

















