package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.followingproject.entity.ProjectAttachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        BeanConfiguration.class,
        SpringSecurityConfiguration.class
})
class ProjectAttachmentForFollowingProjectRepositoryTest {

    @Autowired
    private ProjectAttachmentForFollowingProjectRepository projectAttachmentForFollowingProjectRepository;

    @Test
    public void initTest() {
        assertNotNull(projectAttachmentForFollowingProjectRepository);
    }

    @Test
    @DisplayName("프로젝트 번호로 프로젝트 사진 조회")
    public void findByProjectProjectNoTest() {

        //given
        int projectNo = 355;

        //when
        List<ProjectAttachment> projectAttachmentList = projectAttachmentForFollowingProjectRepository.findByProjectProjectNo(projectNo);

        //then
        projectAttachmentList.forEach(System.out::println);
        assertNotNull(projectAttachmentList);
    }
}