package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectNoticeServiceTest {

    @Autowired
    private ProjectNoticeService ProjectNoticeService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(ProjectNoticeService);
        assertNotNull(modelMapper);
    }

    @Test
    @Transactional
    @DisplayName("프로젝트 번호로 해당 프로젝트의 공지사항 조회 테스트")
    public void findProjectNoticeList_test() {

        int projectNo = 2;

        Pageable pageable = PageRequest.of(1, 10);
        Page<ProjectNoticeDTO> noticeList = ProjectNoticeService.findProjectNoticeList(pageable, projectNo);

        assertNotNull(noticeList);
    }

    @Test
    @DisplayName("프로젝트 공지사항 번호로 공지사항 상세조회 테스트")
    public void findPojectNoticeDetail_test() {

        int projectNoticeNo = 2;

        ProjectNoticeDTO notice = ProjectNoticeService.findProjectNoticeDetail(projectNoticeNo);

        assertNotNull(notice);
    }


}