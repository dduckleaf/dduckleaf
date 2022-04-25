package com.greedy.dduckleaf.projectreport.find.repository;


import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectreport.find.dto.MemberDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportReplyDTO;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class

})
public class ProjectReportReplyRepositoryTests {

    @Autowired
    private ProjectReportReplyRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("프로젝트 신고번호로 신고 답변 조회: 등록된 답변이 존재하는 경우")
    public void findByProjectReportNo_isExist_test() {

        //given
        int projectReportNo = 1;

        //when
        ProjectReportReply replyList = repository.findAllByProjectReport_ProjectReportNoAndDeleteYn(projectReportNo, "N");

        //then
        assertNotNull(replyList);
        System.out.println(replyList);
    }

    @Test
    @DisplayName("프로젝트 신고번호로 신고 답변 조회: 등록된 답변이 없는 경우")
    public void findByProjectReportNo_isEmpty_test() {

        //given
        int projectReportNo = 12;

        //when
        ProjectReportReply reply = repository.findAllByProjectReport_ProjectReportNoAndDeleteYn(projectReportNo, "N");

        //then
        assertNull(reply);
    }

    @Test
    @DisplayName("프로젝트 신고 답변 등록")
    @Transactional
    public void saveReply_test() {

        //given
        ProjectReport projectReport = new ProjectReport();
        projectReport.setProjectReportNo(12);

        long milliseconds = System.currentTimeMillis();
        Date date = new Date(milliseconds);

        ProjectReportReply reply = new ProjectReportReply();
        reply.setProjectReportReplyNo(10);
        reply.setProjectReport(projectReport);
        reply.setProjectReportReplyDate(date);
        reply.setProjectReportReplyContent("content");
        reply.setAdminNo(1);
        reply.setDeleteYn("N");

        //when
        repository.save(reply);
//        ProjectReportReply foundReply = repository.findById(10).get();

        //then
//        assertEquals(reply.getProjectReportReplyNo(), foundReply.getProjectReportReplyNo());
    }
}
