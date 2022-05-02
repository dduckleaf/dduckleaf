package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.common.utility.DateFormatting;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.dto.MemberDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportReplyDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportDetailInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        projectReportList.forEach(report -> {
            assertEquals(report.getClass(), ProjectReportDTO.class);
        });
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("신고 답변 대기 중인 프로젝트 신고목록 조회")
    public void findProjectReportWaitingList_test() {
        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectReportNo").descending());
        String projectReportStatus = "미답변";

        //when
        Page<ProjectReportDTO> projectReportList = service.findProjectsByProjectReportStatus(pageable, projectReportStatus);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(report -> {
            assertEquals(report.getClass(), ProjectReportDTO.class);
        });
        projectReportList.forEach(System.out::println);
    }

    @Test
    @DisplayName("신고 답변 완료 프로젝트 신고목록 조회")
    public void findProjectReportRepliedList_test() {
        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectReportNo").descending());
        String projectReportStatus = "답변완료";

        //when
        Page<ProjectReportDTO> projectReportList = service.findProjectsByProjectReportStatus(pageable, projectReportStatus);

        //then
        assertNotNull(projectReportList);
        projectReportList.forEach(report -> {
            assertEquals(report.getClass(), ProjectReportDTO.class);
        });
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

/*   java.lang.IllegalArgumentException: source cannot be null
 *   null 익셉션 문제를 해결하기 위해 ModelMapper를 상속받아 커스터마이징한 클래스를 config 패키지 하위에 작성하였습니다.
 */
    @Test
    @DisplayName("프로젝트 신고번호로 신고내용 상세 조회: 답변이 존재하지 않는 경우")
    public void findProjectReportAndReply_isEmpty_test() {

        //given
        int projectReportNo = 12;

        //when
        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        //then
        assertNotNull(reportDetailInfo);
        assertNotNull(reportDetailInfo.getProjectReport());
        assertNotNull(reportDetailInfo.getProjectReportReply());
        assertEquals(reportDetailInfo.getProjectReportReply().getProjectReportNo(), 0);

        System.out.println(reportDetailInfo);
    }

    @Test
    @DisplayName("프로젝트 신고 답변 등록 성공 테스트")
    @Transactional
    public void registReply_success_test() {

        //given
        ProjectReportDTO projectReport = new ProjectReportDTO();
        projectReport.setProjectReportNo(12);

        String registDate = DateFormatting.getDateAndTime();

        MemberDTO admin = new MemberDTO();
        admin.setMemberNo(1);

        ProjectReportReplyDTO reply = new ProjectReportReplyDTO();
        reply.setProjectReportReplyNo(100);
        reply.setProjectReportNo(projectReport.getProjectReportNo());
        reply.setProjectReportReplyDate(registDate);
        reply.setProjectReportReplyContent("content");
        reply.setAdminNo(admin.getMemberNo());
        reply.setDeleteYn("N");

        //when
        service.registReply(reply);

        //then
        assertDoesNotThrow(() -> service.registReply(reply));
    }


    @Test
    @DisplayName("프로젝트 신고 답변 등록 실패 테스트")
    @Transactional
    public void registReply_fail_test() {

        //given
        ProjectReportDTO projectReport = new ProjectReportDTO();
        projectReport.setProjectReportNo(12);

        String registDate = DateFormatting.getDateAndTime();

        MemberDTO admin = new MemberDTO();
        admin.setMemberNo(1);

        ProjectReportReplyDTO reply = new ProjectReportReplyDTO();
        reply.setProjectReportReplyNo(2);
        reply.setProjectReportNo(projectReport.getProjectReportNo());
        reply.setProjectReportReplyDate(registDate);
//        reply.setProjectReportReplyContent("content");
        reply.setAdminNo(admin.getMemberNo());
        reply.setDeleteYn("N");

        //when & then
        assertThrows(Exception.class, () -> service.registReply(reply));  //():인자 ->이후:오버라이딩된 구현부
    }

    @Test
    @DisplayName("프로젝트 번호로 해당 프로젝트 신고 목록 조회 테스트 ")
    public void findProjectReportListOfOneProject_test () {
        //given
        int projectNo = 1;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectReportNo").descending());

        //when
        Page<ProjectReportDTO> reportList = service.findProjectReportListOfOneProject(projectNo, pageable);

        //then
        assertNotNull(reportList);
        reportList.forEach(System.out::println);
    }
}
