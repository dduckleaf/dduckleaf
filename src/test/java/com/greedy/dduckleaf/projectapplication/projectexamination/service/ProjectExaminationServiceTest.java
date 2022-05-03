package com.greedy.dduckleaf.projectapplication.projectexamination.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectExaminationServiceTest {

    @Autowired
    private ProjectExaminationService projectExaminationService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(projectExaminationService);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("프로젝트 신청 내역을 조회하는 메소드 테스트")
    public void findProjectApplicationInfo_test() {

        //given
        Pageable pageable = PageRequest.of(1, 10);

        //when
        Page<ProjectApplicationInfoDTO> projectApplicationList = projectExaminationService.findProjectApplicationList(pageable);

        //then
        projectApplicationList.forEach(System.out::println);

    }

}