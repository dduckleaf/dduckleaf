package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
