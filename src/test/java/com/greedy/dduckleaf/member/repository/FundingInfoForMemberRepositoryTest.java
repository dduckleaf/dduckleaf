package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FundingInfoForMemberRepositoryTest {

    @Autowired
    private FundingInfoForMemberRepository fundingInfoForMemberRepository;

    @Test
    public void initTest() {
        assertNotNull(fundingInfoForMemberRepository);
    }
}