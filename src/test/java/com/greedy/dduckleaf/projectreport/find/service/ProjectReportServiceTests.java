package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectReportServiceTests {

    @Autowired
    private ProjectReportService service;

    @Autowired
    private ProjectReportRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(service);
        assertNotNull(repository);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("회원번호로 프로젝트신고내역 목록조회 테스트")
    public void findProjectReportListByMemberNo_test() {
        //given
        int memberNo = 3;

        //when
        List<ProjectReportDTO> projectReportList = service.findProjectReportListByMemberNo(memberNo);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 프로젝트신고내역 목록조회")
    public void findProjectReportList_test() {
        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReportDTO> projectReportList = service.findProjectReportList(pageable);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(System.out::println);
    }
}
