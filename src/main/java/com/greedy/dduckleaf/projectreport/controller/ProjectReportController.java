package com.greedy.dduckleaf.projectreport.controller;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportSummeryInfoDTO;
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
    public ModelAndView findProjectReportListByMemberNo(ModelAndView mv) {
        List<ProjectReportSummeryInfoDTO> projectReportSummeryInfo = service.findProjectReportListByMemberNo(3);

        mv.addObject("projectReportSummeryInfo", projectReportSummeryInfo);
        mv.setViewName("report/list");

        return mv;
    }

    @GetMapping("/detail")
    public void findProjectReportDetail(ModelAndView mv) {

    }
}
