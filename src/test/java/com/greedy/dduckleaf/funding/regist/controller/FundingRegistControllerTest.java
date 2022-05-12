package com.greedy.dduckleaf.funding.regist.controller;

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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class FundingRegistControllerTest {

    @Autowired
    private FundingRegistController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void initTest() {

        assertNotNull(controller);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("펀딩신청 핸들러 메소드 url 매핑 확인")
    public void registFundingPage_url_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/funding/regist/reward/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/funding/regist/fundingamount"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("펀딩신청 핸들러 Model Object 전달 확인")
    public void registFundingPage_model_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/funding/regist/reward/1"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("fundingInfo"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("펀딩신청 배송지 환불계좌 입력 페이지 url요청")
    public void registFundingConfirmPage_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/funding/regist/shipping"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/funding/regist/shippinginfo"))
                .andDo(MockMvcResultHandlers.print());
    }
}