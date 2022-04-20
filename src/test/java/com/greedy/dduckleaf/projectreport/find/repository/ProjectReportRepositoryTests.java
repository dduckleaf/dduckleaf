package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Autowired
    private Member000Repository repository2;



    @Test
    public void initTest() {
        assertNotNull(entityManager);
        assertNotNull(repository);
        assertNotNull(repository2);
    }

    @Test
    @DisplayName("서포터 프로젝트신고목록조회 테스트")
    @Transactional
    public void findProjectReportListByMemberNo_test() {

        int memberNo = 3;

        List<Object> projectReportList = repository.findProjectReportListByMemberNo(memberNo);

        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 신고 조회 테스트")
    @Transactional
    public void test1() {

        List<ProjectReport> projectReportList = repository.findAll();

        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 신고 + 카테고리 조회 테스트")
    @Transactional
    public void test2() {

        List<ProjectReport> projectReportList = repository.findAllWithCategory();

        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }
}
