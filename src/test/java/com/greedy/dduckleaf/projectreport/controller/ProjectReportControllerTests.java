package com.greedy.dduckleaf.projectreport.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.controller.ProjectReportController;
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
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectReportControllerTests {

    @Autowired
    private ProjectReportController controller;
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
    @DisplayName("서포터 프로젝트신고내역 목록조회 테스트")
    public void findProjectReportListByMemberNo_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/report/member/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("report/member/list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("projectReportList"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("모든 프로젝트신고내역 목록조회 테스트")
    public void findAllProjectReportList_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/report/platformmanager/listAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("projectReportList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pagingInfo"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("report/platformmanager/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}