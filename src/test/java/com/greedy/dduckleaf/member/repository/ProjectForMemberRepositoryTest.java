package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.member.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class ProjectForMemberRepositoryTest {

    @Autowired
    private ProjectForMemberRepository projectForMemberRepository;

    @Test
    public void initTest() {
        assertNotNull(projectForMemberRepository);
    }

    @Test
    @DisplayName("회원이 진행중인 프로젝트 조회 테스트")
    public void findProgressProjectTest() {

        //given
        int memberNo = 7;
        List<String> projectProgressStatusNameList = new ArrayList<>();
        projectProgressStatusNameList.add("심사중");
        projectProgressStatusNameList.add("오픈예정");
        projectProgressStatusNameList.add("진행중");
        projectProgressStatusNameList.add("심사대기중");
        projectProgressStatusNameList.add("반려");
        String projectStatus = "Y";

        //when
        List<Project> projectList = projectForMemberRepository.findByProjectProgressStatus_projectProgressStatusNameInAndProjectStatusAndFarmer_memberNo(projectProgressStatusNameList, projectStatus, memberNo);

        //then
        projectList.forEach(System.out::println);
        assertNotEquals(projectList.size(), 0);
    }
}