package com.greedy.dduckleaf.projectreport.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.controller.ProjectReportController;
import com.greedy.dduckleaf.projectreport.find.dto.ReportCategoryDTO;
import com.greedy.dduckleaf.projectreport.find.service.ProjectReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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
    private ProjectReportService service;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void initTest() {
        assertNotNull(controller);
        assertNotNull(service);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("프로젝트 신고번호로 프로젝트 상세내용 조회 테스트")
    public void findProjectReportAndReply_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/report/platformmanager/detail/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("reportDetailInfo"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("report/platformmanager/detail"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("프로젝트 신고번호로 프로젝트 상세내용 조회 테스트")
    public void findProjectReportDetailForProjectManager_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/report/projectmanager/detail/1/4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("reportDetailInfo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("projectNo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("projectReportNo"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("report/projectmanager/detail"))
                .andDo(MockMvcResultHandlers.print());
    }
}
