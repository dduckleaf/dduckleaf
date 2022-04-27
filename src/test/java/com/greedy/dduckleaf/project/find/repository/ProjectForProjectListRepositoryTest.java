package com.greedy.dduckleaf.project.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.project.find.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaRepository.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class ProjectForProjectListRepositoryTest {

    @Autowired
    private ProjectForProjectListRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @Transactional
    public void findProjectList_test() {
//        List<Project> projectList = repo.findByExamineStatusGreaterThanEqual(3);
        List<String> statusList = new ArrayList<>();
        statusList.add("3");
        statusList.add("4");

//        List<Project> projectList = repo.findByExamineStatusIn(statusList);
        List<Project> projectList = repo.findByProgressStatusGreaterThanEqual(3);


        assertNotNull(projectList);

        projectList.forEach(project -> {
            System.out.println("project = " + project);
//            System.out.println("project.getFarmer().getFarmer().getBusinessName() = " + project.getFarmer().getFarmerInfo().getBusinessName());
            System.out.println();
        });

    }
}
















