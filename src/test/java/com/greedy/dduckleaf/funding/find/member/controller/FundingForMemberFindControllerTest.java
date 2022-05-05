//package com.greedy.dduckleaf.funding.find.member.controller;
//
//import com.greedy.dduckleaf.config.BeanConfiguration;
//import com.greedy.dduckleaf.config.DduckleafApplication;
//import com.greedy.dduckleaf.config.JPAConfiguration;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ContextConfiguration(classes = {
//        BeanConfiguration.class,
//        com.greedy.dduckleaf.config.ContextConfiguration.class,
//        DduckleafApplication.class,
//        JPAConfiguration.class
//})
//class FundingForMemberFindControllerTest {
//
//    @Autowired
//    private FundingForMemberFindController controller;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//
//    @Test
//    @DisplayName("init 테스트")
//    public void initTest() {
//
//        assertNotNull(controller);
//    }
//
//    @Test
//    public void findFundingListByMemberNo_test() throws Exception {
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/funding/find/list/member"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl("/funding/find/supporter/fundinglist"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
