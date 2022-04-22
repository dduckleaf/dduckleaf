package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.detail.repository.ProjectReportRepository;
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
    private MemberForProjectReportRepository repository;

    @Test
    public void initTest() {
        assertNotNull(entityManager);
        assertNotNull(repository);
    }

    @Test
    @DisplayName("서포터 정보로 프로젝트신고내역 목록 조회")
    @Transactional
    public void test3() {

        int memberNo = 3;

        Member member = repository.findById(memberNo).get();
        assertNotNull(member);
        System.out.println("member = " + member);

        List<ProjectReport> projectReportList = member.getProjectReportList();
        assertNotNull(projectReportList);
        projectReportList.forEach( projectReport -> {
            System.out.println("projectReport = " + projectReport);
            System.out.println("projectReport.getProject().getProjectName() = " + projectReport.getProject().getProjectName());
            System.out.println("projectReport.getReportCategory().getReportCategoryName() = " + projectReport.getReportCategory().getReportCategoryName());
        });

        System.out.println("projectReportList.size() =  " + projectReportList.size());
    }
}
