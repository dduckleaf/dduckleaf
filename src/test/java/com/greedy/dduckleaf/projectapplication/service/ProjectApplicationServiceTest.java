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

import javax.transaction.Transactional;
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

        //given
        int farmerNo = 68;

        //when & then
        projectApplicationService.registProjectApplication(farmerNo);

    }

    @Test
    @DisplayName("회원번호와 프로젝트 진행상태로 프로젝트 번호를 조회하는 테스트")
    public void findProjectNoByFarmerId_test() {

        //given
        int farmerNo = 68;

        //when
        int projectNo = projectApplicationService.findProjectNoByFarmerId(farmerNo);

        //then
        assertNotEquals(0, projectNo);
    }

    @Test
    @DisplayName("프로젝트 번호로 기본 리워드 등록 정보 데이터 조회하는 테스트")
    public void findBasicReq_test() {

        //given
        int projectNo = 132;

        //when
        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);

        //then
        assertNotNull(basicReq);
        System.out.println("basicReq = " + basicReq);
    }

    @Test
    @DisplayName("기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    @Transactional
    public void modifyBasicReq_test() {

        //given
        int projectNo = 132;

        //when
        RewardRegistInfoDTO updateBasicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);
        updateBasicReq.setRewardPreparingStatus("준비 완료");
        updateBasicReq.setRewardDeliveryPlan("리워드 전달 계획");

        //then
        projectApplicationService.modifyBasicReq(updateBasicReq);

    }

    @Test
    @DisplayName("기본요건 페이지에서 리워드 관련 서류 동의 상태 변경 테스트")
    public void modifyRewardAgreementStatus_test() {

        //given
        int projectNo = 132;

        //when
        RewardRegistInfoDTO basicreq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);
        basicreq.setRewardAgreementStatus("Y");
        basicreq.setRewardAgreementDate(Date.valueOf(LocalDate.now()));

        //then
        projectApplicationService.modifyRewardAgreementStatus(basicreq);
    }
}