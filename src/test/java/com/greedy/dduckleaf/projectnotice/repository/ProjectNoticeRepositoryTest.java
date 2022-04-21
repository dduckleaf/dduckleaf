package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectNoticeRepositoryTest {

    @Autowired
    private ProjectNoticeRepository projectNoticeRepository;

    @Test
    public void initTest() {
        assertNotNull(projectNoticeRepository);
    }

    @Test
    public void findAllByProjectNo_test() {

        int projectNo = 3;
        Pageable pageable = PageRequest.of(10, 10);
        Page<ProjectNotice> noticeList = projectNoticeRepository.findAllByProjectNo(projectNo, pageable);

        assertNotNull(noticeList);
        noticeList.forEach(System.out::println);
    }


}