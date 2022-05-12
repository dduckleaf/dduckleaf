package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.common.utility.DateFormatting;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectReportRepositoryTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProjectReportMainRepository repository;

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

    @Test
    @DisplayName("답변 대기 중인 프로젝트 신고내역 목록조회 테스트")
    public void findWaitingListByProjectReportStatus_test() {

        //given
        String projectReportStatus = "미답변";
        Pageable pageable = PageRequest.of(0,
                10,
                Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReport> projectReportList = repository.findByProjectReportStatus(projectReportStatus, pageable);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("답변 완료 프로젝트 신고내역 목록조회 테스트")
    public void findRepliedListByProjectReportStatus_test() {

        //given
        String projectReportStatus = "답변완료";
        Pageable pageable = PageRequest.of(0,
                10,
                Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReport> projectReportList = repository.findByProjectReportStatus(projectReportStatus, pageable);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트 신고번호로 해당 신고내용 상세조회 테스트")
    public void findByProjectReportNo_test() {
        
        //given
        int projectReportNo = 1;
        
        //when
        ProjectReport projectReport = repository.findByProjectReportNo(projectReportNo);
        
        //then
        assertNotNull(projectReport);
        System.out.println("projectReport = " + projectReport);
    }

    @Test
    @DisplayName("프로젝트 번호로 해당 프로젝트의 신고목록 조회 테스트")
    public void findByProjectNo() {

        //given
        int projectNo = 1;

        Pageable pageable = PageRequest.of(0,
                10,
                Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReport> reportList = repository.findByProject_ProjectNo(projectNo, pageable);
        
        //then
        assertNotNull(reportList);
        reportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트 신고 등록 테스트")
    @Transactional
    public void saveProjectReport_test() {

        //given
        Project project = entityManager.find(Project.class, 1);
        ReportCategory category = entityManager.find(ReportCategory.class, 1);
        Member member = entityManager.find(Member.class, 3);

        ProjectReport report = new ProjectReport();
        report.setMember(member);
        report.setProject(project);
        report.setReportCategory(category);
        report.setProjectReportDate(DateFormatting.getDateAndTime());
        report.setProjectReportContent("content");
        report.setReportRefUrl("url");
        report.setReporterName("name");
        report.setReporterEmail("email");
        report.setReporterPhone("phone");

        //when & then
        assertDoesNotThrow(() -> repository.save(report));
    }

}
