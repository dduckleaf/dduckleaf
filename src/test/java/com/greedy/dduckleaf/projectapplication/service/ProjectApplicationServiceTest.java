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
    @DisplayName("프로젝트 번호로 기본 요건 데이터 조회하는 테스트")
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
        basicreq.setRewardAgreementDate("0000-00-00");

        //then
        projectApplicationService.modifyRewardAgreementStatus(basicreq);
    }

    @Test
    @DisplayName("프로젝트 번호로 기본 정보 데이터 조회하는 테스트")
    public void findBasicInfo_test() {

        //given
        int projectNo = 139;

        //when
        ProjectBasicInfoDTO basicInfo = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);

        //then
        assertNotNull(basicInfo);
        System.out.println("basicInfo = " + basicInfo);

    }

    @Test
    @DisplayName("기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyBasicInfo_test() {

        //given
        int projectNo = 139;

        //when
        ProjectBasicInfoDTO basicInfo = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);
        basicInfo.setProjectName("프로젝트 이름 수정");
        basicInfo.setProjectTargetFund(10000000);
//        basicInfo.setProjectBasicCategoryNo(2);

        //then
        assertDoesNotThrow(() ->projectApplicationService.modifyBasicInfo(basicInfo));
    }

    @Test
    @DisplayName("리워드 카테고리를 조회하는 테스트")
    public void findAllRewardCategory_test() {

        //when & then
        List<ProjectRewardCategoryDTO> category = projectApplicationService.findAllRewardCategory();

        category.forEach(System.out::println);
    }

    @Test
    @DisplayName("스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyStory_test() {

        //given
        int projectNo = 139;

        //when
        ProjectBasicInfoDTO story = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);
        story.setProjectInfo("프로젝트 요약 수정 테스트");

        //then
        assertDoesNotThrow(() ->projectApplicationService.modifyStory(story));

    }

    @Test
    @DisplayName("스토리 작성 페이지에서 프로젝트 홍보 심의 동의 상태 변경 테스트")
    public void modifyPromotionAgreementStatus_test() {

        //given
        int projectNo = 139;

        //when
        ProjectBasicInfoDTO updateStory = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);
        updateStory.setProjectPromotionAgreementStatus("Y");

        //then
        assertDoesNotThrow(() -> projectApplicationService.modifyPromotionAgreementStatus(updateStory));
    }

    @Test
    @DisplayName("프로젝트 번호로 리워드 정보 데이터 조회하는 테스트")
    public void findReward_test() {

        //given
        int projectNo = 139;

        //when
        RewardRegistInfoDTO reward = projectApplicationService.findRewardByProjectNo(projectNo);
        ProjectShippingInfoDTO shippingInfo = projectApplicationService.findShippingInfoByProjectNo(projectNo);

        //then
        assertNotNull(reward);

    }

    @Test
    @DisplayName("리워드 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyReward_test() {

        //given
        int projectNo = 139;

        //when
        RewardRegistInfoDTO reward = projectApplicationService.findRewardByProjectNo(projectNo);
        reward.setRewardName("리워드 명");
        reward.setRewardPrice(0);
        reward.setRewardInfo("리워드 상세 설명");

        ProjectShippingInfoDTO shippingInfo = projectApplicationService.findShippingInfoByProjectNo(projectNo);
        shippingInfo.setShippingFee(0);
        shippingInfo.setExtraShippingFee(0);
        shippingInfo.setShippingDueDate(java.sql.Date.valueOf(LocalDate.now().plusMonths(11)).toString());

        //then
        assertDoesNotThrow(() ->projectApplicationService.modifyReward(reward, shippingInfo));

    }

    @Test
    @DisplayName("프로젝트 번호로 정책 정보 데이터 조회하는 테스트")
    public void findPolicyByProjectNo_test() {

        //given
        int projectNo = 139;

        //when
        RefundPolicyDTO policy = projectApplicationService.findPolicyByProjectNo(projectNo);

        //then
        assertNotNull(policy);

    }

    @Test
    @DisplayName("스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyPolicy_test() {

        //given
        int projectNo = 139;

        //when
        RefundPolicyDTO policy = projectApplicationService.findPolicyByProjectNo(projectNo);
        policy.setRefundPolicyContent("서비스 수정 테스트");

        //then
        assertDoesNotThrow(() ->projectApplicationService.modifyPolicy(policy));

    }

    @Test
    @DisplayName("반환정책 작성 페이지에서 펀딩금 반환 정책 정보 동의 상태 변경 테스트")
    public void modifyPolicyAgreementStatus_test() {

        //given
        int projectNo = 139;

        //when
        RefundPolicyDTO policy = projectApplicationService.findPolicyByProjectNo(projectNo);
        policy.setRefundPolicyAgreementStatus("Y");

        //then
        assertDoesNotThrow(() -> projectApplicationService.modifyPolicyAgreementStatus(policy));
    }

}