package com.greedy.dduckleaf.projectreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class ProjectReportController {

    @GetMapping("/list")
    public void projectReportPage() {
        System.out.println("왔나?");
    }
}
