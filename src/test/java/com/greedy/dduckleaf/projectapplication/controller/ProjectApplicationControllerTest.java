package com.greedy.dduckleaf.projectapplication.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.projectapplication.controller.ProjectApplicationController;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    @DisplayName("리워드 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyReward_test() throws Exception {

        //given
        MultiValueMap<String, String> reward = new LinkedMultiValueMap<>();
        reward.add("projectNo", "139");

        MultiValueMap<String, String> shippingInfo = new LinkedMultiValueMap<>();
        reward.add("projectNo", "139");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/reward").params(reward).params(shippingInfo))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("반환정책 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyPolicy_test() throws Exception {

        //given
        MultiValueMap<String, String> policy = new LinkedMultiValueMap<>();
        policy.add("projectNo", "139");
        policy.add("refundPolicyContent", "컨트롤러 수정 테스트");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/policy").params(policy))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("사용자가 펀딩금 반환 정책 정보 동의 시 동의 여부와 날짜 업데이트하는 테스트")
    public void modifyPolicyAgreementStatus_test() throws Exception {

        //given
        MultiValueMap<String, String> policy = new LinkedMultiValueMap<>();
        policy.add("projectNo", "140");
        policy.add("refundPolicyAgreementStatus", "Y");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/policyagreement").params(policy))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/policy"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("파머정보 작성 페이지에서 사용자가 입력한 값으로 기본데이터를 수정하는 테스트")
    public void modifyFarmerInfo_test() throws Exception {

        //given
        MultiValueMap<String, String> farmerInfo = new LinkedMultiValueMap<>();
        farmerInfo.add("memberNo", "68");
        farmerInfo.add("farmerName", "박휘림");
        farmerInfo.add("farmerEmail", "hwirim797@gmail.com");
        farmerInfo.add("farmerPhone", "010-6693-3114");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/modify/farmer").params(farmerInfo))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/goMain"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("대표자 정보 페이지에서 사용자가 정산정책 정보 확인 시 확인 상태를 변경하는 테스트")
    public void modifySettlementPolicyCheckStatus_test() throws Exception {

        //given
        MultiValueMap<String, String> financialInfo = new LinkedMultiValueMap<>();
        financialInfo.add("farmerNo", "68");
        financialInfo.add("settlementPolicyCheckStatus", "Y");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/project/application/settlementcheck").params(financialInfo))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/project/application/representative"))
                .andDo(MockMvcResultHandlers.print());

    }

}