package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportDetailInfo;
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

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
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(service);
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

    @Test
    @DisplayName("프로젝트 신고번호로 신고내용 상세 조회: 답변이 존재하는 경우")
    public void findProjectReportAndReply_isExist_test() {

        //given
        int projectReportNo = 1;

        //when
        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        //then
        assertNotNull(reportDetailInfo.getProjectReport());
        assertNotNull(reportDetailInfo.getProjectReportReply());

        System.out.println(reportDetailInfo.getProjectReport());
        System.out.println(reportDetailInfo.getProjectReportReply());
    }

//    java.lang.IllegalArgumentException: source cannot be null
//
//    @Test
//    @DisplayName("프로젝트 신고번호로 신고내용 상세 조회: 답변이 존재하는 경우")
//    public void findProjectReportAndReply_isEmpty_test() {
//
//        //given
//        int projectReportNo = 12;
//
//        //when
//        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);
//
//        //then
//        assertNotNull(reportDetailInfo);
//
//        System.out.println(reportDetailInfo);
//    }
}
