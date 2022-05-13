package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectnotice.dto.ProjectDTO;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.greedy.dduckleaf.project.finalfield.CodeForProject.BUTTON_AMOUNT;

/**
 * <pre>
 * Class: ProjectNoticeController
 * Comment : 프로젝트 공지사항
 * History
 * 2022/04/18 (박휘림) 처음 작성 / 목록 조회 메소드 작성 시작
 * 2022/04/21 (박휘림) 목록 조회 메소드 작성 완료, 공지사항 상세조회 메소드 작성 시작
 * 2022/04/22 (박휘림) 공지사항 상세조회 메소드 작성 완료, 공지사항 작성하기 메소드 작성 시작
 * 2022/04/23 (박휘림) 공지사항 작성하기 메소드 작성 완료, 공지사항 수정하기 메소드 작성 시작
 * 2022/04/24 (박휘림) 공지사항 수정하기,삭제하기 메소드 작성 완료
 * 2022/04/24 (박휘림) 회원 번호로 진행 중인 프로젝트 번호 조회 메소드 작성
 * </pre>
 * @version 1.0.6
 * @author 박휘림
 */
@Controller
@RequestMapping("/project/notice")
public class ProjectNoticeController {

    private final ProjectNoticeService projectService;

    @Autowired
    public ProjectNoticeController(ProjectNoticeService projectService) {
        this.projectService = projectService;
    }

    /**
     * findProjectNoticeList: 프로젝트 공지사항 목록을 조회합니다.
     * @param pageable: 페이징 정보를 담는 객체
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            projectNoticeList 해당 프로젝트의 공지사항 목록
     *            paging 목록 페이징을 위한 객체
     *            "projectnotice/list" 프로젝트 공지사항 목록을 출력하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping (value = "/list/{projectNo}", produces = "application/json")
    @ResponseBody
    public ModelAndView findProjectNoticeList(ModelAndView mv, @PageableDefault Pageable pageable, @AuthenticationPrincipal CustomUser user, @PathVariable int projectNo) {

        Page<ProjectNoticeDTO> projectNoticeList = projectService.findProjectNoticeList(pageable, projectNo);
        ProjectDTO project = projectService.findProjectInfo(projectNo);
        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectNoticeList, BUTTON_AMOUNT);

        mv.addObject("project", project);
        mv.addObject("projectNoticeList", projectNoticeList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("intent", "list/{projectNo}");
        mv.setViewName("projectnotice/list");

        return mv;
    }

    /**
     * findProjectNoByFarmerNo: 로그인한 회원번호로 진행중인 프로젝트의 번호를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return projectNo 로그인한 사용자가 진행 중인 프로젝트 번호
     * @author 박휘림
     */
    public int findProjectNoByFarmerNo(@AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        int projectNo = projectService.findProjectNoByFarmerId(farmerNo);

        return projectNo;
    }

    /**
     * findProjectNoticeDetail: 프로젝트 공지사항 상세정보를 조회합니다.
     * @param projectNoticeNo: 조회할 프로젝트 공지사항 번호
     * @return mv
     *            projectNoticeDetail 조회하려는 공지사항 상세정보
     *            "projectnotice/detail" 프로젝트 공지사항 상세정보를 출력하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping(value = "/detail/{projectNoticeNo}", produces = "application/json")
    @ResponseBody
    public ModelAndView findProjectNoticeDetail(ModelAndView mv, @PathVariable int projectNoticeNo) {

        ProjectNoticeDTO projectNoticeDetail = projectService.findProjectNoticeDetail(projectNoticeNo);

        mv.addObject("projectNoticeDetail", projectNoticeDetail);
        mv.setViewName("projectnotice/detail");

        return mv;
    }

    /**
     * registPage: 프로젝트 공지사항을 작성하기 위해 작성 폼으로 이동합니다.
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "projectnotice/regist" 프로젝트 공지사항 작성하기폼을 출력하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/regist/{projectNo}")
    public ModelAndView registPage(ModelAndView mv, @PathVariable int projectNo) {
        ProjectDTO project = projectService.findProjectInfo(projectNo);
        mv.setViewName("projectnotice/regist");
        mv.addObject("project", project);
        return mv;
    }

    /**
     * registProjectNotice: 프로젝트 공지사항을 등록합니다.
     * @param user: 로그인한 사용자의 정보를 받기위한 객체
     * @param newNotice: 등록할 공지사항 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *         "redirect:/project/notice/list"
     * @author 박휘림
     */
    @PostMapping("/regist")
    public ModelAndView registProjectNotice(ModelAndView mv, @AuthenticationPrincipal CustomUser user,
                                            ProjectNoticeDTO newNotice) {

        int farmerNo = user.getMemberNo();
//
        newNotice.setFarmerNo(farmerNo);

        projectService.registProjectNotice(newNotice);

        mv.setViewName("redirect:/project/notice/list/" + newNotice.getProjectNo());

        return mv;
    }

    /**
     * modifyPage: 프로젝트 공지사항을 작성하기 위해 작성 폼으로 이동합니다.
     * @param projectNoticeNo: 수정할 프로젝트 공지사항 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "projectnotice/modify" 프로젝트 공지사항 수정하기폼을 출력하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/modify/{projectNoticeNo}")
    public ModelAndView modifyPage(ModelAndView mv, @PathVariable int projectNoticeNo) {

        ProjectNoticeDTO projectNoticeDetail = projectService.findProjectNoticeDetail(projectNoticeNo);

        mv.addObject("projectNoticeDetail", projectNoticeDetail);
        mv.setViewName("projectnotice/modify");

        return mv;
    }

    /**
     * modifyProjectNotice: 프로젝트 공지사항을 수정합니다.
     * @param updateNotice: 수정할 프로젝트 공지사항 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/notice/list"
     * @author 박휘림
     */
    @PostMapping("/modify")
    public ModelAndView modifyProjectNotice(ModelAndView mv, ProjectNoticeDTO updateNotice) {

        projectService.modifyProjectNotice(updateNotice);

        mv.setViewName("redirect:/project/notice/list/" + updateNotice.getProjectNo());

        return mv;
    }

    /**
     * removeProjectNotice: 프로젝트 공지사항을 삭제합니다.
     * @param projectNoticeNo: 삭제할 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/notice/list"
     * @author 박휘림
     */
    @GetMapping("/remove/{projectNoticeNo}")
    public ModelAndView removeProjectNotice(ModelAndView mv, @PathVariable int projectNoticeNo) {

        int projectNo = projectService.removeProjectNotice(projectNoticeNo);

        mv.setViewName("redirect:/project/notice/list/" + projectNo);

        return mv;
    }

}
