package com.greedy.dduckleaf.projectapplication.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectApplicationControllerTest {

    @Autowired
    private ProjectApplicationController projectApplicationController;
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(projectApplicationController).build();
    }

    @Test
    public void initTest() {
        assertNotNull(projectApplicationController);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터 수정하는 테스트")
    public void modifyBasicReq_test() throws Exception {

        //given
        MultiValueMap<String, String> basicreq = new LinkedMultiValueMap<>();
        basicreq.add("projectNo", "132");
        basicreq.add("rewardPreparingStatus", "컨트롤러 수정 테스트");
        basicreq.add("rewardDeliveryPlan", "컨트롤러 수정 테스트");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/basicreq").params(basicreq))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("사용자가 리워드 관련 서류 제출에 동의 시 동의 여부와 날짜 업데이트하는 테스트")
    public void modifyRewardAgreementStatus_test() throws Exception {

        //given
        MultiValueMap<String, String> basicreq = new LinkedMultiValueMap<>();
        basicreq.add("projectNo", "132");
        basicreq.add("rewardAgreementStatus", "Y");
        basicreq.add("rewardAgreementDate", "2022-4-28");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/rewardagreement").params(basicreq))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/basicreq"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyBasicInfo_test() throws Exception {

        //given
        MultiValueMap<String, String> basicInfo = new LinkedMultiValueMap<>();
        basicInfo.add("projectNo", "132");
        basicInfo.add("projectName", "컨트롤러 수정 테스트");
        basicInfo.add("projectEndDate", "2022-05-30");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/basicinfo").params(basicInfo))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyStory_test() throws Exception {

        //given
        MultiValueMap<String, String> story = new LinkedMultiValueMap<>();
        story.add("projectNo", "139");
        story.add("projectInfo", "프로젝트 요약 수정");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/story").params(story))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }
}