package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectnotice.entity.FarmerInfo;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
public class ProjectNoticeRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProjectNoticeRepository projectNoticeRepository;


    @Test
    public void initTest() {
        assertNotNull(entityManager);
        assertNotNull(projectNoticeRepository);
    }

    @Test
    @Transactional
    public void 파머코드_프로젝트코드로_프로젝트공지사항_조회_테스트() {

//        int farmerNo = 1;
//        int projectNo = 2;

        List<ProjectNotice> projectNoticeList = projectNoticeRepository.findAll();


        assertNotNull(projectNoticeList);
        System.out.println("projectNoticeList = " + projectNoticeList);
        projectNoticeList.forEach(System.out::println);
    }
}
