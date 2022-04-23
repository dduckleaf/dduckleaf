package com.greedy.dduckleaf.projectreport.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    * 메소드에 관한 설명
    *  @param first 첫 번째 파라미터에 대한 설명
    * @param second 두 번째 파라미터에 대한 설명
    * @return 리턴값에 대한 설명
    * @exception 예외 이유에 대한 설명
    */
    @GetMapping("/detail")
    public void findProjectReportDetail(ModelAndView mv) {

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
    public ModelAndView findAllProjectReportList(ModelAndView mv, Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectReportList(pageable);

        System.out.println("projectReportList = " + projectReportList);
        projectReportList.forEach(System.out::println);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.setViewName("report/platformmanager/list");

        return mv;
    }
}
