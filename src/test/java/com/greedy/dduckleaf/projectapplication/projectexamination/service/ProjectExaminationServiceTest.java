package com.greedy.dduckleaf.projectapplication.projectexamination.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.*;
import com.greedy.dduckleaf.projectapplication.entity.FarmerFinancialInfo;
import com.greedy.dduckleaf.projectapplication.entity.ProjectApplicationInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectExaminationServiceTest {

    @Autowired
    private ProjectExaminationService projectExaminationService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(projectExaminationService);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("프로젝트 신청 내역을 조회하는 메소드 테스트")
    public void findProjectApplicationInfo_test() {

        //given
        Pageable pageable = PageRequest.of(1, 10);

        //when
        Page<ProjectApplicationInfoDTO> projectApplicationList = projectExaminationService.findProjectApplicationList(pageable);

        //then
        projectApplicationList.forEach(System.out::println);

    }

    @Test
    @DisplayName("프로젝트 신청 내역을 상세조회하는 메소드 테스트")
    public void findProjectApplicationDetail_test() {

        //given
        int projectApplicationNo = 20;

        //when
        ProjectApplicationInfoDTO projectApplicationInfo = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        //then
        assertNotNull(projectApplicationInfo);
    }

    @Test
    @DisplayName("프로젝트 상태를 심사중으로 변경하는 메소드 테스트")
    public void modifyProjectProgressStatus_test() {

        //given
        int projectApplicationNo = 20;

        //when
        ProjectApplicationInfoDTO projectApplicationInfo = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);
        projectApplicationInfo.setProjectApplicationCategory("심사중");

        //then
        assertDoesNotThrow(() -> projectExaminationService.modifyProjectProgressStatus(projectApplicationNo));
    }

    @Test
    @DisplayName("프로젝트 신청 시 업로드한 기본정보 첨부파일 정보를 조회하는 메소드 테스트")
    public void findBasicInfoAttachmentByProjectNo_test() {

        //given
        int projectNo = 215;

        //when
        ProjectAttachmentDTO attachment = projectExaminationService.findBasicInfoAttachmentByProjectNo(projectNo);

        //then
        assertNotNull(attachment);
    }

    @Test
    @DisplayName("프로젝트 신청 시 업로드한 스토리 첨부파일 정보를 조회하는 메소드 테스트")
    public void findStoryAttachmentByProjectNo_test() {

        //given
        int projectNo = 215;

        //when
        ProjectAttachmentDTO attachment = projectExaminationService.findStoryAttachmentByProjectNo(projectNo);

        //then
        assertNotNull(attachment);
    }

    @Test
    @DisplayName("프로젝트 신청 시 업로드한 파머 첨부파일 정보를 조회하는 메소드 테스트")
    public void findFarmerInfoAttachment_test() {

        //given
        int projectNo = 215;

        //when
        ProjectAttachmentDTO attachment = projectExaminationService.findFarmerInfoAttachment(projectNo);

        //then
        assertNotNull(attachment);
    }

    @Test
    @DisplayName("프로젝트 신청 시 등록한 파머 금융 정보를 조회하는 메소드 테스트")
    public void findFarmerFinancialInfo_test() {

        //given
        int memberNo = 68;

        //when
        FarmerFinancialInfoDTO farmer = projectExaminationService.findFarmerFinancialInfo(memberNo);

        //then
        assertNotNull(farmer);
    }
}