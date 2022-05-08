package com.greedy.dduckleaf.project.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;

import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.projectmanage.service.ProjectManageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : ProjectManagerController
 * Comment : 관리자 페이지의 프로젝트 관리 업무를 담당하는 컨트롤러 클래스입니다.
 *
 * History
 * 2022-05-01 (박휘림) 처음 작성 / findScheduledProjectList 메소드 작성
 * </pre>
 *
 * @author 박휘림
 * @version 1.0.0
 */
@Controller
@RequestMapping("/project/manage")
public class ProjectManageController {

    private final ProjectManageService projectManageService;

    public ProjectManageController(ProjectManageService projectManageService) {
        this.projectManageService = projectManageService;
    }

    /**
     * findScheduledProjectList: 공개예정인 프로젝트 목록을 조회하는 메소드입니다.
     * @return 공개예정 프로젝트 목록, 프로젝트관리 공개예정 프로젝트 목록조회 화면경로
     * @author 박휘림
     */
    @GetMapping("/scheduled/list")
    public ModelAndView findScheduledProjectList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectDTO> projectList = projectManageService.findScheduledProjectList(pageable);
        projectList.forEach(System.out::println);
        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectList);

        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("projectList", projectList);
        mv.addObject("intent", "progressing/list");
        mv.setViewName("project/manage/scheduled/list");
        return mv;
    }
}
