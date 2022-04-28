package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class ProjectFindServiceTest {

    @Autowired
    private ProjectFindService service;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    public void findProjectList_test() {

        List<ProjectDTO> projectList = service.findProjectList();

        assertNotNull(projectList);

        projectList.forEach(System.out::println);
    }

}