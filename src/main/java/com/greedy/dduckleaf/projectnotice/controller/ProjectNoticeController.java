package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.service.ProjectNoticeService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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
 * </pre>
 * @version 1.0.5
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
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            projectNoticeList 해당 프로젝트의 공지사항 목록
     *            paging 목록 페이징을 위한 객체
     *            "projectnotice/list" 프로젝트 공지사항 목록을 출력하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping (value = "/list", produces = "application/json")
    @ResponseBody
    public ModelAndView findProjectNoticeList(/*HttpServletRequest request,*/ ModelAndView mv,//일단 검색 기능 보류
                                                                              @PageableDefault Pageable pageable/*, @PathVariable(value = "projectNo") int projectNo*/) {
        int projectNo = 2;
        Page<ProjectNoticeDTO> projectNoticeList = projectService.findProjectNoticeList(pageable, projectNo);

        System.out.println("projectNoticeList = " + projectNoticeList);
        projectNoticeList.forEach(System.out::println);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectNoticeList);

        mv.addObject("projectNoticeList", projectNoticeList);
        mv.addObject("paging", paging);
        mv.setViewName("projectnotice/list");

        return mv;
    }

    /**
     * findProjectNoticeDetail: 프로젝트 공지사항 목록을 조회합니다.
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
    @GetMapping("/regist")
    public ModelAndView registPage(ModelAndView mv) {

        mv.setViewName("projectnotice/regist");

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

//        int farmerNo = user.getMemberNo();
        int farmerNo = 4;
        int projectNo = 2;

        newNotice.setFarmerNo(farmerNo);
        newNotice.setProjectNo(projectNo);

        System.out.println("newNotice = " + newNotice);

        projectService.registProjectNotice(newNotice);

        mv.setViewName("redirect:/project/notice/list");

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
        System.out.println("updateNotice = " + updateNotice);
        projectService.modifyProjectNotice(updateNotice);

        mv.setViewName("redirect:/project/notice/list");
        return mv;
    }

    /**
     * removeProjectNotice: 프로젝트 공지사항을 삭제합니다.
     * @param projectNoticeNo: 삭제할 프로젝트 공지사항 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/notice/list"
     * @author 박휘림
     */
    @GetMapping("/remove/{projectNoticeNo}")
    public ModelAndView removeProjectNotice(ModelAndView mv, @PathVariable int projectNoticeNo) {

        projectService.removeProjectNotice(projectNoticeNo);

        mv.setViewName("redirect:/project/notice/list");
        return mv;
    }

}
