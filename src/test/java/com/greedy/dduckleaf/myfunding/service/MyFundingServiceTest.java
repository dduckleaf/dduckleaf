package com.greedy.dduckleaf.myfunding.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.myfunding.dto.MyFundingDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class
})
class MyFundingServiceTest {

    @Autowired
    private MyFundingService myFundingService;

    @Test
    public void initTest() {
        assertNotNull(myFundingService);
    }

    @Test
    @DisplayName("회원의 마이펀딩조회")
    public void findMyFundingByMemberNoTest() {

        //given
        int memberNo = 5;

        //when
        MyFundingDTO myFunding = myFundingService.findMyFundingByMemberNo(memberNo);

        //then
        System.out.println(myFunding);
        assertNotNull(myFunding);
    }

}