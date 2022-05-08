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

    @Test
    @DisplayName("관심 프로젝트 조회 테스트")
    public void findByFollowingProjectTest() {

        //given
        int memberNo = 5;
        int projectNo = 7;

        //when
        FollowingProject followingProject = followingProjectRepository.findByProjectNoAndMemberNo(projectNo, memberNo);

        //then
        System.out.println(followingProject);
        assertNotNull(followingProject);
    }

    @Test
    @DisplayName("관심프로젝트 취소 테스트")
    @Transactional
    public void removeFollowingProjectTest() {

        //given
        int followingProjectNo = 5;

        //when

        //then
        assertDoesNotThrow(() -> followingProjectRepository.deleteById(followingProjectNo));
    }
}