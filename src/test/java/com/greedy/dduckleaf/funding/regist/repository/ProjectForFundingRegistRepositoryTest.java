package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.regist.entity.ProjectForFundingRegist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class ProjectForFundingRegistRepositoryTest {

    @Autowired
    private ProjectForFundingRegistRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void findAll_test() {

        List<ProjectForFundingRegist> projectInfoList =  repo.findAll();
        assertNotNull(projectInfoList);
        projectInfoList.forEach(System.out::println);
    }

}