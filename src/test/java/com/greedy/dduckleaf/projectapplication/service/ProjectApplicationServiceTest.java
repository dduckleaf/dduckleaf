package com.greedy.dduckleaf.projectapplication.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.*;
import com.greedy.dduckleaf.projectapplication.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectApplicationServiceTest {

    @Autowired
    private ProjectApplicationService projectApplicationService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(projectApplicationService);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("회원이 프로젝트 신청을 누르면 펀딩 준비 관련 테이블에 기본 데이터를 삽입하는 테스트")
    public void registAllProjectInfo_test() {

        int farmerNo = 68;

        projectApplicationService.registProjectApplication(farmerNo);

    }

    @Test
    public void findBasicReq_test() {

        int projectNo = 1;

        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);

        assertNotNull(basicReq);
        System.out.println("basicReq = " + basicReq);
    }

}