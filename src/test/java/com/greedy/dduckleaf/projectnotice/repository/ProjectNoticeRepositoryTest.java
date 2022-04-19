package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        BeanConfiguration.class,
        JPAConfiguration.class})
public class ProjectNoticeRepositoryTest {


    @Autowired
    private ProjectNoticeRepository projectNoticeRepository;


    @Test
    public void initTest() {
        assertNotNull(projectNoticeRepository);
    }

    @Test
    @Transactional
    public void 파머코드_프로젝트코드로_프로젝트공지사항_조회_테스트() {


        List<ProjectNotice> list = projectNoticeRepository.findAll();
        list.forEach(System.out::println);


    }
}
