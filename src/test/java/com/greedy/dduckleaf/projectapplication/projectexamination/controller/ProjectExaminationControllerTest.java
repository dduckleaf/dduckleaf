package com.greedy.dduckleaf.projectapplication.projectexamination.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectExaminationControllerTest {

    @Autowired
    private ProjectExaminationController projectExaminationController;
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(projectExaminationController).build();
    }

    @Test
    public void initTest() {
        assertNotNull(projectExaminationController);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("프로젝트 신청 내역 상세조회하는 메소드 테스트")
    public void findProjectApplicationInfoDetail_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/detail/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/detail"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 상태 변경하는 메소드 테스트")
    public void modifyProjectProgressStatus_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/modify/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/review"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 기본 요건 조회하는 메소드 테스트")
    public void findBasicReq_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/basicreq/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/basicreq"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 기본 정보 조회하는 메소드 테스트")
    public void findBasicInfo_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/basicinfo/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/basicinfo"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 스토리 정보 조회하는 메소드 테스트")
    public void findStory_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/story/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/story"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 리워드 정보 조회하는 메소드 테스트")
    public void findReward_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/reward/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/reward"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 정책 정보 조회하는 메소드 테스트")
    public void findPolicy_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/policy/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/policy"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 파머 정보 조회하는 메소드 테스트")
    public void findFarmer_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/farmer/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/farmerinfo"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("프로젝트 대표자 정보 조회하는 메소드 테스트")
    public void findRepresentative_test() throws Exception {

        int projectApplicationNo = 20;

        mockMvc.perform(MockMvcRequestBuilders.get("/project/examination/representative/" + projectApplicationNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/manage/application/representative"))
                .andDo(MockMvcResultHandlers.print());

    }


}