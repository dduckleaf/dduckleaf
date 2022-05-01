package com.greedy.dduckleaf.project.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import com.greedy.dduckleaf.settlement.service.SettlementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Class : ProjectManagerController
 * Comment : 관리자 페이지의 프로젝트 관리 업무를 담당하는 컨트롤러 클래스입니다.
 *
 * History
 * 2022-05-01 (장민주) 처음 작성 / findEndProjectsAchievedSuccess 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Controller
@RequestMapping("/project/manage")
public class ProjectManagerController {

    private final SettlementService settlementService;

    public ProjectManagerController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    /**
     * findEndProjectsAchievedSuccess: 달성률이 100% 이상인 종료된 프로젝트 조회를 요청하는 메소드입니다.
     * @param pageable: 페이징 정보
     * @return 프로젝트 목록
     * @author 장민주
     */
    @GetMapping("/end/endlist")
    public ModelAndView findEndProjectsAchievedSuccess(ModelAndView mv,
       @PageableDefault(size = 10, sort = "projectNo", direction = Sort.Direction.DESC) Pageable pageable,
       HttpServletRequest request) {

        int progressStatus = 4;
        int achievementRate = 100;
        request.getParameter("searchCondition");
        request.getParameter("searchValue");
        Page<ProjectDTO> projects = settlementService.findAllEndProjectsAchievedSuccess(progressStatus, achievementRate, pageable);
        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projects);

        mv.addObject("projects", projects);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("intent", "end/endlist");
        mv.setViewName("/project/manage/end/endlist");

        return mv;
    }

    /**
     * findProjectDetail: 프로젝트 번호로 프로젝트 상세 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 상세정보, 프로젝트관리 상세조회 화면경로
     * @author 장민주
     */
    @GetMapping("/end/detail/{projectNo}")
    public ModelAndView findProjectDetail(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = settlementService.findProjectDetail(projectNo);

        mv.addObject("project", project);
        mv.setViewName("project/manage/end/detail");

        return mv;
    }
}