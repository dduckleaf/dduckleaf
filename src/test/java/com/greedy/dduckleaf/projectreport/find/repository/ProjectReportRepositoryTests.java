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
        assertNotNull(entityManager);
        assertNotNull(repository);
    }

    @Test
    @DisplayName("서포터 프로젝트신고목록조회 테스트")
    public void findProjectReportListByMemberId_test() {
        //given
        String memberId = "USER01";

        //when
        List<ProjectReport> reportList = repository.findProjectReportListByMemberId(memberId);

        //then
        assertNotNull(reportList);
        reportList.forEach(System.out::println);

    }
}
