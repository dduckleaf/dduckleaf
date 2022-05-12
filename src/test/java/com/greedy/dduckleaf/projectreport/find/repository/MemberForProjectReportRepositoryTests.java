package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class MemberForProjectReportRepositoryTests {

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
    @DisplayName("로그인한 회원의 회원번호로 프로젝트신고내역 목록 조회")
    @Transactional
    public void findMemberByMemberNo_test() {
        //given
        int memberNo = 3;

        //when
        Member member = repository.findById(memberNo).get();

        //then
        assertNotNull(member);
        System.out.println("member = " + member);

        List<ProjectReport> projectReportList = member.getProjectReportList();
        assertNotNull(projectReportList);
        projectReportList.forEach( projectReport -> {
            System.out.println("projectReport = " + projectReport);
            System.out.println("projectReport.getProject().getProjectName() = " + projectReport.getProject().getProjectName());
            System.out.println("projectReport.getReportCategory().getReportCategoryName() = " + projectReport.getReportCategory().getReportCategoryName());
        });

        ProjectReport foundReport = entityManager.find(ProjectReport.class, 1);
        assertNotNull(foundReport);    //영속성으로 관리되고있음

        System.out.println("projectReportList.size() =  " + projectReportList.size());
    }
}


