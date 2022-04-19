package com.greedy.dduckleaf.projectnotice.controller;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("list")
    public ModelAndView findProjectNoticeList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectNoticeDTO> projectNoticeList = projectNoticeService.findProjectNoticeList(pageable);



        return mv;
    }

}
