package com.greedy.dduckleaf.followingproject.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.followingproject.dto.FollowingProjectDTO;
import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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
class FollowingProjectServiceTest {

    @Autowired
    private FollowingProjectService followingProjectService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(followingProjectService);
    }

    @Test
    @DisplayName("관심프로젝트 등록 테스트")
    @Transactional
    public void registFollowingProjectTest() {

        //given
        FollowingProjectDTO followingProject = new FollowingProjectDTO();
        followingProject.setProjectNo(7);
        followingProject.setMemberNo(67);

        //when
        String result = followingProjectService.registFollowingProject(followingProject);

        //then
        System.out.println(result);
        assertEquals(result, "관심프로젝트로 등록되었습니다.");
    }

    @Test
    @DisplayName("관심 프로젝트 취소 테스트")
    @Transactional
    public void removeFollowingProjectTest() {

        //given
        int projectNo = 7;
        int memberNo = 5;

        //when
        String result = followingProjectService.removeFollowingProject(projectNo, memberNo);

        //then
        System.out.println(result);
        assertEquals(result, "관심 프로젝트에서 제외되었습니다.");
    }

}