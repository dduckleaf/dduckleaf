package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.common.paging.Pagenation;
import com.greedy.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/project/notice")
public class ProjectNoticeController {

    private final ProjectNoticeService projectService;

    @Autowired
    public ProjectNoticeController(ProjectNoticeService projectService) {
        this.projectService = projectService;
    }

    @GetMapping (value = "/list/{projectNo}", produces = "application/json")
    @ResponseBody
    public ModelAndView findProjectNoticeList(/*HttpServletRequest request,*/ ModelAndView mv,//일단 검색 기능 보류
                                                                              @PageableDefault Pageable pageable, @PathVariable int projectNo) {

        Page<ProjectNoticeDTO> projectNoticeList = projectService.findProjectNoticeList(pageable, projectNo);

        System.out.println("projectNoticeList = " + projectNoticeList);
        projectNoticeList.forEach(System.out::println);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectNoticeList);

        mv.addObject("projectNoticeList", projectNoticeList);
        mv.addObject("paging", paging);
        mv.setViewName("project/notice/list");

        return mv;
    }

    @GetMapping(value = "/detail/{projectNoticeNo}", produces = "application/json")
    @ResponseBody
    public ModelAndView findProjectNoticeDetail(ModelAndView mv, @PathVariable int projectNoticeNo) {

        ProjectNoticeDTO projectNoticeDetail = projectService.findProjectNoticeDetail(projectNoticeNo);

        mv.addObject("projectNoticeDetail", projectNoticeDetail);
        mv.setViewName("project/notice/detail");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView registProjectNotice(ModelAndView mv, RedirectAttributes rttr) {

        ProjectNoticeDTO newNotice = new ProjectNoticeDTO();

        projectService.save(newNotice);

        rttr.addFlashAttribute("message", "공지사항이 등록되었습니다.");

//        mv.setViewName("미확정");
        return mv;
    }





}
