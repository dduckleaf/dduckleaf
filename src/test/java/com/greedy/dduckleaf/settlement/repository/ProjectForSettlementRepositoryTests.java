package com.greedy.dduckleaf.settlement.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectForSettlementRepositoryTests {

    @Autowired
    private ProjectForSettlementRepository repository;

    @Test
    public void initTest() {
        assertNotNull(repository);
    }

    @Test
    @DisplayName("종료된 프로젝트 중 달성률이 100% 이상인 프로젝트 조회 테스트")
    public void findByProjectStatusAndProgressStatusAndAchievementRateGreaterThanEqual_test() {

        //given
        String projectStatus = "Y";
        int progressStatus = 4;
        int achievementRate = 100;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectNo").descending());

        //when
        Page<Project> projects =
                repository.findByProjectStatusAndProgressStatusAndAchievementRateGreaterThanEqual(projectStatus, progressStatus, achievementRate, pageable);

        //then
        assertNotNull(projects);
        projects.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트 번호로 프로젝트 상세 조회")
    public void findByProjectNo_test() {

        //given
        int projectNo = 1;

        //when
        Project projectDetail = repository.findByProjectNo(projectNo);

        //then
        assertNotNull(projectDetail);
        System.out.println("projectDetail = " + projectDetail);
    }
}
