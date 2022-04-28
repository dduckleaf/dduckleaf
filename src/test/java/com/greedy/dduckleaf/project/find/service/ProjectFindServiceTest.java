package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

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
    public void findProjectLists_test() {

        Pageable pageable = PageRequest.of(1, 10);
        String searchValue = "3";

        Page<ProjectDTO> projectList = service.findProjectLists(searchValue, pageable);

        assertNotNull(projectList);

        projectList.forEach(System.out::println);
    }

}