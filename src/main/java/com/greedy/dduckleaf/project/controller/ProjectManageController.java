package com.greedy.dduckleaf.project.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;

import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.projectmanage.service.ProjectManageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.greedy.dduckleaf.project.finalfield.CodeForProject.BUTTON_AMOUNT;

/**
 * <pre>
 * Class : ProjectManagerController
 * Comment : 관리자 페이지의 프로젝트 관리 업무를 담당하는 컨트롤러 클래스입니다.
 *
 * History
 * 2022-05-01 (박휘림) 처음 작성 / findScheduledProjectList 메소드 작성
 * 2022-05-11 (박휘림) findProjectApplicationInfoDetail, openProject 메소드 작성
 * </pre>
 *
 * @author 박휘림
 * @version 1.0.1
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

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("projectList", projectList);
        mv.addObject("intent", "scheduled/list");
        mv.setViewName("project/manage/scheduled/list");
        return mv;
    }

    /**
     * findProjectApplicationInfoDetail: 오픈예정 프로젝트 상세조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/scheduled/detail" 프로젝트 신청 내역 상세 페이지
     * @author 박휘림
     */
    @GetMapping("/scheduled/detail/{projectNo}")
    public ModelAndView findProjectApplicationInfoDetail(ModelAndView mv, @PathVariable int projectNo) {

        ProjectApplicationInfoDTO detail = projectManageService.findProjectApplicationDetail(projectNo);

        mv.addObject("detail", detail);
        mv.setViewName("project/manage/scheduled/detail");

        return mv;
    }

    /**
     * openProject: 오픈예정 프로젝트를 진행 중으로 상태변경합니다.
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/manage/scheduled/list" 오픈예정 프로젝트 목록 조회
     * @author 박휘림
     */
    @GetMapping("/open")
    public ModelAndView openProject(ModelAndView mv, RedirectAttributes rttr) {

        String result = projectManageService.openProject();

        mv.setViewName("redirect:/project/manage/scheduled/list");
        rttr.addFlashAttribute("message", result);
        return mv;
    }

    /**
     * findProgressingProjectList: 진행 중인 프로젝트 목록을 조회하는 메소드입니다.
     * @return 진행 중 프로젝트 목록, 프로젝트관리 진행 중 프로젝트 목록조회 화면경로
     * @author 박휘림
     */
    @GetMapping("/progressing/list")
    public ModelAndView findProgressingProjectList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectDTO> projectList = projectManageService.findProgressingProjectList(pageable);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("projectList", projectList);
        mv.addObject("intent", "progressing/list");
        mv.setViewName("project/manage/progressing/list");
        return mv;
    }

    /**
     * findProgressingProjectApplicationInfoDetail: 진행 중 프로젝트 상세조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/progressing/detail" 진행 중 프로젝트 상세 페이지
     * @author 박휘림
     */
    @GetMapping("/progressing/detail/{projectNo}")
    public ModelAndView findProgressingProjectApplicationInfoDetail(ModelAndView mv, @PathVariable int projectNo) {

        ProjectApplicationInfoDTO detail = projectManageService.findProjectApplicationDetail(projectNo);

        mv.addObject("detail", detail);
        mv.setViewName("project/manage/progressing/detail");

        return mv;
    }

    /**
     * openProject: 오픈예정 프로젝트를 진행 중으로 상태변경합니다.
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/manage/scheduled/list" 오픈예정 프로젝트 목록 조회
     * @author 박휘림
     */
    @GetMapping("/end")
    public ModelAndView endProject(ModelAndView mv, RedirectAttributes rttr) {

        String result = projectManageService.endProject();

        mv.setViewName("redirect:/project/manage/progressing/list");
        rttr.addFlashAttribute("message", result);

        return mv;
    }
}
