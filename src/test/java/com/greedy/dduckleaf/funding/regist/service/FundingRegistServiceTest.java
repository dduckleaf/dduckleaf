package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.regist.dto.ProjectForFundingRegistDTO;
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
        DduckleafApplication.class,
        JPAConfiguration.class
})
class FundingRegistServiceTest {

    @Autowired
    private FundingRegistService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }
    
    @Test
    @DisplayName("한 프로젝트의 펀딩등록 시 필요 정보 조회 테스트")
    public void findProjectInfoById_test() {
        int projectNo = 1;

        ProjectForFundingRegistDTO projectInfoDTO = service.findProjectFundingInfo(projectNo);
        
        assertNotNull(projectInfoDTO);
        System.out.println("projectInfoDTO = " + projectInfoDTO);
    }

}











































