package com.greedy.dduckleaf.projectapplication.farmerpage.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.RefundPolicyDTO;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FarmerPageServiceTest {

    @Autowired
    private FarmerPageService farmerPageService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(farmerPageService);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("파머탭에서 반환 정책을 조회하는 메소드 테스트")
    public void findRefundPolicy_test() {

        //given
        int projectNo = 300;

        //when
        RefundPolicyDTO refundPolicy = farmerPageService.findRefundPolicy(projectNo);

        //then
        assertNotNull(refundPolicy);
    }

    @Test
    @DisplayName("파머탭에서 리워드 정보를 조회하는 메소드 테스트")
    public void findRewardInfo_test() {

        //given
        int projectNo = 300;

        //when
        RewardRegistInfoDTO reward = farmerPageService.findRewardInfo(projectNo);

        //then
        assertNotNull(reward);
    }

}