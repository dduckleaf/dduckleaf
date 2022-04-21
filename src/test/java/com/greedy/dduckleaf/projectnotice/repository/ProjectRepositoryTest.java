//package com.greedy.dduckleaf.projectnotice.repository;
//
//import com.greedy.dduckleaf.config.BeanConfiguration;
//import com.greedy.dduckleaf.config.DduckleafApplication;
//import com.greedy.dduckleaf.config.JPAConfiguration;
//import com.greedy.dduckleaf.projectnotice.entity.Project;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
//class ProjectRepositoryTest {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Test
//    public void initTest() {
//        assertNotNull(projectRepository);
//    }
//
//
//    @Test
//    public void findAll_test() {
//
//        List<Project> projectList = projectRepository.findAll();
//
//        assertNotNull(projectList);
//        projectList.forEach(System.out::println);
//    }
//
//
//
//
//}