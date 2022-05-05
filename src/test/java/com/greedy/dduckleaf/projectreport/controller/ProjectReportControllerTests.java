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

    @Test
    @DisplayName("비동기 방식으로 모든 프로젝트 신고유형 목록 조회 요청 테스트")
    public void findAllReportCategories_test() throws Exception {

        String reportCategories = controller.findAllReportCategories();

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/report/categories"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath(reportCategories)
                        .value("{\"reportCategoryNo\":1,\"reportCategoryName\":\"스토리 내 허위사실\",\"reportCategoryContent\":\"스토리에 사실이 아닌 내용이 있어요리워드를 받아 보니 스토리에 있는 내용과 달라요\"},{\"reportCategoryNo\":2,\"reportCategoryName\":\"동일 제품의 타 채널 유통\",\"reportCategoryContent\":\"같은 농산물을 떡잎 펀드 발송 전에 다른 곳에서 (예약)판매하고 있어요\"},{\"reportCategoryNo\":3,\"reportCategoryName\":\"떡잎펀드 정책위반\",\"reportCategoryContent\":\"프로젝트 및 게시물에 아래의 콘텐츠가 포함되어 있어요- 타인을 모욕, 명예훼손하는 콘텐츠- 개인정보를 침해하는 콘텐츠- 차별, 음란, 범죄 등 불건전한 콘텐츠\"},{\"reportCategoryNo\":4,\"reportCategoryName\":\"기타\",\"reportCategoryContent\":\"파머와 연락/의사소통이 잘 되지 않아요\"}"))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryNo").value(reportCategories.get(0).getReportCategoryNo()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryNo").value(reportCategories.get(1).getReportCategoryNo()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryNo").value(reportCategories.get(2).getReportCategoryNo()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryNo").value(reportCategories.get(3).getReportCategoryNo()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryName").value(reportCategories.get(0).getReportCategoryName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryName").value(reportCategories.get(1).getReportCategoryName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryName").value(reportCategories.get(2).getReportCategoryName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryName").value(reportCategories.get(3).getReportCategoryName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryContent").value(reportCategories.get(0).getReportCategoryContent()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryContent").value(reportCategories.get(1).getReportCategoryContent()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryContent").value(reportCategories.get(2).getReportCategoryContent()))
//                .andExpect(MockMvcResultMatchers.jsonPath("reportCategoryContent").value(reportCategories.get(3).getReportCategoryContent()))
                .andDo(MockMvcResultHandlers.print());

    }



}
