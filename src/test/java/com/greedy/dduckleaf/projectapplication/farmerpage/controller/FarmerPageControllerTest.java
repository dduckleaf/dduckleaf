package com.greedy.dduckleaf.projectapplication.farmerpage.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
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
        DduckleafApplication.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FarmerPageControllerTest {

    @Autowired
    private FarmerPageController farmerPageController;
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(farmerPageController).build();
    }

    @Test
    public void initTest() {
        assertNotNull(farmerPageController);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("파머탭에서 반환 정책을 조회하는 메소드 테스트")
    public void findRefundPolicy_test() throws Exception {

        int projectNo = 300;

        mockMvc.perform(MockMvcRequestBuilders.get("/farmerpage/policy/" + projectNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl(""))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("파머탭에서 리워드 정보를 조회하는 메소드 테스트")
    public void findRewardInfo_test() throws Exception {

        int projectNo = 300;

        mockMvc.perform(MockMvcRequestBuilders.get("/farmerpage/reward/" + projectNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl(""))
                .andDo(MockMvcResultHandlers.print());

    }
}