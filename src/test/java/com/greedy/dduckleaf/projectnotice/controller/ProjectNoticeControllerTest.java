package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectNoticeControllerTest {

    @Autowired
    private ProjectNoticeController projectController;
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    public void initTest() {
        assertNotNull(projectController);
        assertNotNull(mockMvc);
    }

//    @Test
//    public void findProjectNoticeList_test() throws Exception {
//
//        int projectNo = 2;
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/project/notice/list/" + projectNo))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl("project/notice/list"))
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    @DisplayName("프로젝트 번호로 해당 프로젝트의 공지사항 목록 조회 테스트")
    public void findProjectNoticeList_test() throws Exception {

        int projectNo = 2;
        Pageable pageable = PageRequest.of(10, 10);

        mockMvc.perform(MockMvcRequestBuilders.get("/projectNotice/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("project/notice/list"))
                .andDo(MockMvcResultHandlers.print());

    }



}