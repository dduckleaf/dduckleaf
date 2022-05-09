package com.greedy.dduckleaf.settlement.controller;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementControllerTests {

    @Autowired
    private SettlementController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() { mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); }

    @Test
    public void initTest() {
        assertNotNull(controller);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("파머 회원의 프로젝트 정산정보 조회 요청 테스트")
    public void findFarmerSettlementOverview_test() throws Exception {

        //given
        int projectNo = 1;

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/settlement/farmer/overview/" + projectNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("project"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("settlementInfo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("feeInfo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("settlementPaymentInfos"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("settlement/farmer/overview"))
                .andDo(MockMvcResultHandlers.print());
    }
}
