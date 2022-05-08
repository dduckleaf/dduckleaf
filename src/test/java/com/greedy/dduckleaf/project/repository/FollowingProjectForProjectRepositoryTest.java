package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.followingproject.repository.FollowingProjectRepository;
import com.greedy.dduckleaf.project.entity.FollowingProject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class FollowingProjectForProjectRepositoryTest {

    @Autowired
    private FollowingProjectForProjectRepository followingProjectForProjectRepository;

    @Test
    @DisplayName("관심프로젝트로 등록했는지 조회 테스트")
    public void findFollowingProjectTest() {

        //given
        int memberNo = 67;
        int projectNo = 7;

        //when
        List<FollowingProject> followingProjectList = followingProjectForProjectRepository.findByMemberNoAndProjectNo(memberNo, projectNo);

        //then
        System.out.println(followingProjectList);
        assertEquals(followingProjectList.size(), 0);
    }
}