package com.greedy.dduckleaf.projectreport.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportReplyDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportDetailInfo;
import com.greedy.dduckleaf.projectreport.find.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : FundingRegistController
 * Comment : 프로젝트 신고 프로세스를 담당하는 컨트롤러 클래스.
 * History
 * 2022/04/18 : findProjectReportListByMemberNo 메소드 작성.
 * 2022/04/22 : findProjectReportDetail 메소드 작성.
 * 2022/04/23 : platformManagerDefaultPage 메소드 작성.
 * 2022/04/23 :  findAllProjectReportList 메소드 작성.
 * </pre>
 * @version 1.0.2
 * @author 장민주
 */
@Controller
@RequestMapping("/report")
public class ProjectReportController {

    @Autowired
    private final ProjectReportService service;

    public ProjectReportController(ProjectReportService service) {
        this.service = service;
    }

    /**
    * 회원번호로 로그인회원의 프로젝트신고내역 조회 요청 메소드입니다.
    *  @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
    * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     *           projectReportSummeryInfo : 프로젝트신고내역 요약정보
     *           "report/list" : 요약정보를 출력할 브라우저 화면 경로
    */
    @GetMapping("/list")
    public ModelAndView findProjectReportListByMemberNo(@AuthenticationPrincipal CustomUser user, ModelAndView mv) {

        int memberNo = user.getMemberNo();
        System.out.println("memberNo = " + memberNo);

        List<ProjectReportDTO> projectReportList = service.findProjectReportListByMemberNo(memberNo);
        System.out.println("projectReportList = " + projectReportList);
        
        mv.addObject("projectReportList", projectReportList);
        mv.setViewName("report/list");

        return mv;
    }

    /**
     * 서포터 마이페이지 하위의 신고관리메뉴에서 보내는 프로젝트 신고번호로 프로젝트신고내역 상세조회 요청 메소드입니다.
     *  @param projectReportNo 상세조회를 요청할 프로젝트신고번호
     * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     *            projectReportInfo : 프로젝트신고내역 상세정보
     *            "report/detail" : 상세정보를 출력할 브라우저 화면 경로
     */
    @GetMapping("/detail/{projectReportNo}")
    public ModelAndView findProjectReportDetailForMember(ModelAndView mv, @PathVariable int projectReportNo) {

        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        mv.addObject("reportDetailInfo", reportDetailInfo);
        mv.setViewName("report/detail");

        return mv;
    }

    /**
    * 관리자페이지 플랫폼관리 메뉴 하위의 신고관리 첫 화면으로 이동하기 위한 getMapping 메소드입니다
    */
    @GetMapping("/platformmanager/default")
    public void platformManagerDefaultPage() {}

    /**
     * 프로젝트 신고내역 전체조회 요청 메소드입니다.
     * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     *            projectReportSummaryInfo : 프로젝트신고내역 요약정보
     *            "report/platformmanager/list" : 요약정보를 출력할 브라우저 화면 경로
     */
    @GetMapping("/platformmanager/listAll")
    public ModelAndView findAllProjectReportList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectReportList(pageable);

        System.out.println("projectReportList = " + projectReportList);
        projectReportList.forEach(System.out::println);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.setViewName("report/platformmanager/list");

        return mv;
    }

    /**
    * 플랫폼관리 하위의 신고관리메뉴에서 보내는 프로젝트 신고번호로 프로젝트신고내역 상세조회 요청 메소드입니다.
    *  @param projectReportNo 상세조회를 요청할 프로젝트신고번호
    * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
    *            projectReportInfo : 프로젝트신고내역 상세정보
    *            "report/platformmanager/detail" : 상세정보를 출력할 브라우저 화면 경로
    */
    @GetMapping("/platformmanager/detail/{projectReportNo}")
    public ModelAndView findProjectReportDetail(ModelAndView mv, @PathVariable int projectReportNo) {

        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        mv.addObject("reportDetailInfo", reportDetailInfo);
        mv.setViewName("report/platformmanager/detail");

        return mv;
    }

    @GetMapping("/platformmanager/regist")
    public void registpage() {}

    @PostMapping("/platformmanager/regist")
    public void registProjectReportReply(@ModelAttribute("projectReportReply")ProjectReportReplyDTO projectReportReply, @AuthenticationPrincipal CustomUser user) {
        System.out.println("projectReportReply = " + projectReportReply);

    }
}
