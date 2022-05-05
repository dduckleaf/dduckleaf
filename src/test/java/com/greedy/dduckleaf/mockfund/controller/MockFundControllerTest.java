package com.greedy.dduckleaf.mockfund.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
import com.greedy.dduckleaf.mockfund.entity.RewardCategory;
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

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class MockFundControllerTest {
    
    @Autowired
    private MockFundController mockFundController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mockFundController).build();
    }

    @Test
    public void initTest() {
        assertNotNull(mockFundController);
        assertNotNull(mockMvc);
    }
    // redirect : is3xxRedirection()
    @Test
    @DisplayName("모의펀딩 기본정보 페이지 url 매핑 테스트")
    public void findMockFundInfoByCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/mockfund/basicinfo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/mockfund/regist/basicinfo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("info"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("categoryList"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("모의펀딩 스토리 페이지 url 매핑 테스트")
    public void findStoryInfoByCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/mockfund/story/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/mockfund/regist/story"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("info"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("모의펀딩 리워드 정보 페이지 url 매핑 테스트")
    public void findRewardByCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/mockfund/reward/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/mockfund/regist/reward"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("info"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("모의펀딩 메인페이지 url 매핑 테스트")
    public void findMockFundStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/mockfund/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/mockfund/mockfundmain"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mockFund"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("모의펀딩 스토리 동의하기 url 매핑 테스트")
    public void modifyMockFundAgreementStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/mockfund/agreement"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/mockfund/story/1"))
                .andDo(MockMvcResultHandlers.print());
    }


}