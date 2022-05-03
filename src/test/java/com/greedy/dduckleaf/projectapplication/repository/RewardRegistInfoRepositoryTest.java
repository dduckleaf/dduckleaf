package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.entity.RewardRegistInfo;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.RewardRegistInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class RewardRegistInfoRepositoryTest {

    @Autowired
    private RewardRegistInfoRepository rewardRegistInfoRepository;

    @Test
    public void initTest() {

        assertNotNull(rewardRegistInfoRepository);
    }

    @Test
    @DisplayName("프로젝트 번호로 리워드 정보 조회 테스트")
    public void findByProjectNo_test() {

        //given
        int projectNo = 132;

        //when
        RewardRegistInfo rewardRegistInfo = rewardRegistInfoRepository.findByProjectNo(projectNo);

        //then
        assertNotNull(rewardRegistInfo);

    }


}