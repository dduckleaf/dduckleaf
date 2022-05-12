package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.dto.SearchDTO;
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

        Pageable pageable = PageRequest.of(0, 10);
        String searchValue = "나";
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSearchValue(searchValue);
        Page<ProjectDTO> projectList = service.findProjectLists(searchDTO, pageable);

        assertNotNull(projectList);

        projectList.forEach(System.out::println);
    }

    @Test
    public void findProjectLists_npe_test() {

        Pageable pageable = PageRequest.of(0, 10);
        String searchValue = "3";
        SearchDTO searchDTO = new SearchDTO(null, 1, 3);
        searchDTO.setSearchValue(searchValue);

        Page<ProjectDTO> projectList = service.findProjectLists(searchDTO, pageable);

        assertNotNull(projectList);

        projectList.forEach(System.out::println);
    }

}