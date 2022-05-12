package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class ProjectForShippingRepositoryTest {

    @Autowired
    private ProjectForShippingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("파머 프로젝트 조회")
    public void findProjectNoByFarmerMemberNo() {

        //given
        int memberNo = 5;

        //when
        List<Project> projectList = repo.findProjectNoByFarmerMemberNo(memberNo);

        //then
        assertNotNull(projectList);
        projectList.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("프로젝트 번호로 프로젝트 조회")
    public void findProjectNoByProjectNoTest() {
        
        //given
        int projectNo = 343;

        //when
        Project project = repo.findProjectNoByProjectNo(projectNo);
        
        //then
        assertNotNull(project);
        System.out.println("project = " + project);
    }

}