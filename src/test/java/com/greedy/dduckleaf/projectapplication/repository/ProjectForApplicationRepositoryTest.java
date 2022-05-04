package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.entity.Project;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.ProjectForApplicationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectForApplicationRepositoryTest {

    @Autowired
    private ProjectForApplicationRepository projectForApplicationRepository;

    @Test
    public void initTest() {
        assertNotNull(projectForApplicationRepository);
    }

    @Test
    @DisplayName("파머번호와 진행상태로 프로젝트 조회 테스트")
    public void findByFarmerNoAndAndProgressStatus_test() {

        //given
        int farmerNo = 68;
        int progressStatus = 1;

        //when
        Project project = projectForApplicationRepository.findByFarmerNoAndAndProgressStatus(farmerNo, progressStatus);

        //then
        assertNotNull(project);

    }

}