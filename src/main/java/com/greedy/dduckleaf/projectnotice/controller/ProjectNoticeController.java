package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/projectNotice")
public class ProjectNoticeController {

    private final ProjectNoticeService projectNoticeService;

    @Autowired
    public ProjectNoticeController(ProjectNoticeService projectNoticeService) {

        this.projectNoticeService = projectNoticeService;
    }

//    @GetMapping("/list")
//    public ModelAndView findProjectNoticeList(ModelAndView mv, @PageableDefault Pageable pageable) {
//
//        System.out.println("pageable = " + pageable);
//
//        Page<ProjectNoticeDTO> projectNoticeList = projectNoticeService.findProjectNoticeList(pageable);
//
//        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectNoticeList);
//
//        System.out.println("projectNoticeList = " + projectNoticeList);
//
//        mv.addObject("projectNoticeList", projectNoticeList);
//        mv.addObject("paging", paging);
//        mv.setViewName("project/notice/list");
//
//        return mv;
//    }

    @GetMapping("/list")
    public ModelAndView findProjectNoticeList(ModelAndView mv) {

        List<ProjectNoticeDTO> projectNoticeList = projectNoticeService.selectProjectNoticeList();

        mv.addObject("projectNoticeList", projectNoticeList);
        mv.setViewName("/project/notice/list");

        return mv;
    }



//    private MemberDTO selectMemberNoById(@AuthenticationPrincipal User user) {
//
//        String id = user.getUsername();
//
//        MemberDTO member = projectNoticeService.selectMemberNoById(id);
//
//        return member;
//    }
}
