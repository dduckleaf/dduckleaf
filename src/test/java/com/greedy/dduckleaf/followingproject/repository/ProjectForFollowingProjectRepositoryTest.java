package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.followingproject.entity.Project;
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
class ProjectForFollowingProjectRepositoryTest {

    @Autowired
    private ProjectForFollowingProjectRepository projectForFollowingProjectRepository;

    @Test
    public void initTest() {
        assertNotNull(projectForFollowingProjectRepository);
    }

    @Test
    @DisplayName("회원의 등록한 관심프로젝트[진행중] 목록 조회 테스트")
    public void findAllFollowingProjectListTest() {

        //given
        int memberNo = 67;

        //when
        List<Project> findFollowingProjectList = projectForFollowingProjectRepository.findFollowingProjectList(memberNo);

        //then
        findFollowingProjectList.forEach(System.out::println);
        assertEquals(findFollowingProjectList.size(), 0);
    }
}