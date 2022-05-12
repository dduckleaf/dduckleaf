package com.greedy.dduckleaf.main.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.main.entity.ProjectAttachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class
})
class ProjectAttachmentForMainRepositoryTest {

    @Autowired
    private ProjectAttachmentForMainRepository projectAttachmentForMainRepository;

    @Test
    public void initTest() {
        assertNotNull(projectAttachmentForMainRepository);
    }

    @Test
    @DisplayName("프로젝트의 사진 목록 조회")
    public void findProjectAttachmentListTest() {

        //given
        int projectNo = 355;

        //when
        List<ProjectAttachment> projectAttachmentList = projectAttachmentForMainRepository.findByProjectProjectNo(projectNo);

        //then
        projectAttachmentList.forEach(System.out::println);
        assertNotNull(projectAttachmentList);
    }

}