package com.greedy.dduckleaf.projectreport.detail.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReportReply;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportReplyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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
public class ProjectReportRepositoryReplyTests {

    @Autowired
    private ProjectReportReplyRepository repository;

    @Test
    public void initTest() {
        assertNotNull(repository);
    }

    @Test
    @DisplayName("")
    public void findByProjectReportNo_test() {

        //given
        int projectReportNo = 1;

        //when
        List<ProjectReportReply> replyList = repository.findAll();
//        ProjectReportReply reply = repository.findByProjectReportNo(projectReportNo);

        //then
        assertNotNull(replyList);
        replyList.forEach(System.out::println);
    }
}
