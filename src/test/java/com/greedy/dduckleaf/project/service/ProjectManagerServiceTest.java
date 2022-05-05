package com.greedy.dduckleaf.project.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.projectmanage.service.ProjectManageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class ProjectManagerServiceTest {

    @Autowired
    private ProjectManageService projectManageService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(projectManageService);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("진행예정 프로젝트 목록 조회 메소드 테스트")
    public void findScheduledProjectList_test() {

        //given
        Pageable pageable = PageRequest.of(1, 10);

        //when
        Page<ProjectDTO> projectList = projectManageService.findScheduledProjectList(pageable);

        //then
        projectList.forEach(System.out::println);
    }
}