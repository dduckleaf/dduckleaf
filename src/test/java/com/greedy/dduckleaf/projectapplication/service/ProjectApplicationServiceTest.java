package com.greedy.dduckleaf.projectapplication.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.*;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.time.LocalDate;

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

//    @Test
//    @DisplayName("회원이 프로젝트 신청을 누르면 펀딩 준비 관련 테이블에 기본 데이터를 삽입하는 테스트")
//    public void registAllProjectInfo_test() {
//
//        int projectNo = 9;
//
////        FarmerInfoDTO farmerInfoDTO = new FarmerInfoDTO();
//
//        ProjectDTO openProject = new ProjectDTO();
//        openProject.setProjectName("프로젝트 명");
//        openProject.setOpenDate(Date.valueOf(LocalDate.now()));
//        openProject.setEndDate(Date.valueOf(LocalDate.now().plusMonths(1)));
//        openProject.setFarmerNo(68);
//        openProject.setProgressStatus(1);
//        openProject.setProjectStatus("Y");
//        openProject.setProjectNo(10);
//
//        System.out.println("openProject = " + openProject);
//
//        RewardRegistInfoDTO reward = new RewardRegistInfoDTO();
////        reward.setRewardPreparingStatus("리워드 준비상태를 작성해주세요");
//        reward.setRewardPreparingStatus("준비상태");
//        reward.setRewardDeliveryPlan("리워드 전달계획을 작성해주세요");
//        reward.setRewardPrice(0);
//        reward.setRewardName("리워드 명");
//        reward.setRewardInfo("리워드 소개를 간단히 적어주세요");
//        reward.setRewardUnit("리워드 단위");
//        reward.setProjectNo(openProject.getProjectNo());
//
//        FarmerInfoDTO farmerInfo = new FarmerInfoDTO();
//        FarmerFinancialInfoDTO farmerFinancialInfoDTO = new FarmerFinancialInfoDTO();
//
//
//
//
//        projectApplicationService.openProject(openProject.getProjectNo());
//
//    }

    @Test
    public void findBasicReq_test() {

        int projectNo = 1;

        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);

        assertNotNull(basicReq);
        System.out.println("basicReq = " + basicReq);
    }

}