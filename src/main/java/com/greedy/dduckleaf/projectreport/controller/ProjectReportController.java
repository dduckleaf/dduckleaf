package com.greedy.dduckleaf.projectreport.controller;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ProjectReportController {

    @Autowired
    private final ProjectReportService service;

    public ProjectReportController(ProjectReportService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView projectReportPage(ModelAndView mv) {
        List<ProjectReportDTO> reportList = service.findProjectReportListByMemberId("USER01");

        mv.addObject("reportList", reportList);
        mv.setViewName("report/list");

        System.out.println(reportList);
        return mv;
    }
}
