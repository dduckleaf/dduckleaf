package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectReportRepositoryTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProjectReportRepository repository;

    @Test
    public void initTest() {
        assertNotNull(entityManager);
        assertNotNull(repository);
    }

    @Test
    @DisplayName("모든 프로젝트신고내역 목록조회 테스트")
    public void findAll_test() {
        //given
        Pageable pageable = PageRequest.of(0,
                10,
                Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReport> projectReportList = repository.findAll(pageable);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);

    }

    /*=========================================너는 사용하지 말아봐봐*/
    @Test
    @DisplayName("모든 프로젝트신고내역 목록조회")
    public void findAllProjectReport_test() {
        //given

        //when
        List<Object> projectReportList = repository.findAllProjectReport();

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }
}
