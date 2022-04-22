package com.greedy.dduckleaf.projectreport.detail.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Test
    public void initTest() {
        assertNotNull(repository);
    }

    @Test
    @DisplayName("프로젝트 신고번호로 신고내역 상세조회 테스트")
    public void findByProjectReportNo_test() {

        List<ProjectReport> projectReportList = repository.findAll();

        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
//        List<Object> reportAndReply = repository.findReportAndReply();
//        assertNotNull(reportAndReply.toString());
//        System.out.println("reportAndReply = " + reportAndReply);
    }

}
