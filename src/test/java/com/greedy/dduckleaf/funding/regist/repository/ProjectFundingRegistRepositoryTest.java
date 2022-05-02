package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class ProjectFundingRegistRepositoryTest {

    @Autowired
    private ProjectFundingRegistRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("프로젝트의 배송비, 리워드 정보 전체 조회 테스트")
    public void findAll_test() {

        List<Project> projectInfoList =  repo.findAll();
        assertNotNull(projectInfoList);
        projectInfoList.forEach(System.out::println);
        assertDoesNotThrow(() -> repo.save(new Project()));
    }

    @Test
    @DisplayName("프로젝트 번호로 특정 프로젝트의 배송비, 리워드정보 조회")
    public void findById_test() {

        Project projectInfo = repo.findById(1).get();
        assertNotNull(projectInfo);
    }

    @Test
    public void findProjectListTest() {

        Project project = repo.findById(1).get();

        assertNotNull(project);
        System.out.println("project = " + project);

    }

}