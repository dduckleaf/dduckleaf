package com.greedy.dduckleaf.projectreport.find.repository;


import com.greedy.dduckleaf.common.utility.DateFormatting;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class

})
public class ProjectReportReplyRepositoryTests {

    @Autowired
    private ProjectReportReplyRepository repository;

    @Autowired
    private ProjectReportMainRepository reportRepository;

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
        int projectReportNo = 16;

        //when
        ProjectReportReply reply = repository.findAllByProjectReport_ProjectReportNoAndDeleteYn(projectReportNo, "N");

        //then
        assertNull(reply);
    }

    @Test
    @DisplayName("프로젝트 신고 답변 등록")
    public void saveReply_test() {

        //given
        int projectReportNo = 15;
        ProjectReport projectReport = reportRepository.findById(projectReportNo).get();

        String registDate = DateFormatting.getDateAndTime();

        ProjectReportReply reply = new ProjectReportReply();
        reply.setProjectReport(projectReport);
        reply.setProjectReportReplyDate(registDate);
        reply.setProjectReportReplyContent("content");
        reply.setAdminNo(1);
        reply.setDeleteYn("N");

        //when & then
        assertDoesNotThrow(() -> repository.save(reply));
    }
}
