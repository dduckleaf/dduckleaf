package com.greedy.dduckleaf.projectreport.find.repository;


import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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
}
