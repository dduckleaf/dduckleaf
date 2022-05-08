package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FollowingProjectRepositoryTest {

    @Autowired
    private FollowingProjectRepository followingProjectRepository;

    @Test
    public void initTest() {
        assertNotNull(followingProjectRepository);
    }

    @Test
    @DisplayName("관심프로젝트 등록 테스트")
    @Transactional
    public void registFollowingProjectTest() {

        //given
        FollowingProject followingProject = new FollowingProject();
        followingProject.setProjectNo(7);
        followingProject.setMemberNo(67);

        //when

        //then
        assertDoesNotThrow(() -> followingProjectRepository.save(followingProject));
    }
}