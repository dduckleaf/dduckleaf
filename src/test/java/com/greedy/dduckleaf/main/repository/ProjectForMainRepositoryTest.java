package com.greedy.dduckleaf.main.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.main.entity.Project;
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
        JPAConfiguration.class,
        DduckleafApplication.class
})
class ProjectForMainRepositoryTest {

    @Autowired
    private ProjectForMainRepository projectForMainRepository;

    @Test
    public void initTest() {
        assertNotNull(projectForMainRepository);
    }

    @Test
    @DisplayName("모든 프로젝트 조회")
    public void findByAllProjectTest() {

        //given

        //when
        List<Project> projectList = projectForMainRepository.findAll();

        //then
        projectList.forEach(System.out::println);
        assertNotNull(projectList);
    }

    @Test
    @DisplayName("진행중인 프로젝트 조회")
    public void findProjectByProgressTest() {

        //given

        //when
        List<Project> projectList = projectForMainRepository.findDduckleafRecommendList();

        //then
        projectList.forEach(System.out::println);
        assertNotNull(projectList);
    }

    @Test
    @DisplayName("달성률 높은 프로젝트 5개 조회 테스트")
    public void findRankingListTest() {

        //given

        //when
        List<Project> rankingList = projectForMainRepository.findRankingList();

        //then
        rankingList.forEach(System.out::println);
        assertNotNull(rankingList);
    }
}