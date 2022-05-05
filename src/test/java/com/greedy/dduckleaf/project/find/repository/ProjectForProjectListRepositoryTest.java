package com.greedy.dduckleaf.project.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.project.find.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void findByProjectExamineStatusIsNotNullAndProjectNameContaining_test() {

        //given
        Pageable pageable = PageRequest.of(0,10);
        String searchValue = "2";

        //when
        Page<Project> projects = repo.findByProjectExamineStatusIsNotNullAndProjectNameContaining(searchValue, pageable);

        //then
        assertNotNull(projects);
        projects.forEach(System.out::println);
    }

    @Test
    public void findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNo_test() {

        //given
        Pageable pageable = PageRequest.of(0,10);
        int progressStatus = 3;

        //when
        Page<Project> projects = repo.findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNo(progressStatus, pageable);

        //then
        assertNotNull(projects);
        projects.forEach(System.out::println);

    }

    @Test
    public void findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNoAndProjectBasicInfo_category_categoryNo() {

        //given
        Pageable pageable = PageRequest.of(0,10);
        int progressStatus = 3;
        int rewardCategory = 1;

        //when
        Page<Project> projects = repo.findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNoAndBasicInfo_category_projectCategoryNo(progressStatus, rewardCategory, pageable);

        assertNotNull(projects);
        projects.forEach(System.out::println);

    }

}
















