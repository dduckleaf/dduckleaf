package com.greedy.dduckleaf.funding.regist.controller;

import com.greedy.dduckleaf.funding.regist.dto.FundingRegistDTO;
import com.greedy.dduckleaf.funding.regist.dto.ProjectDTO;
import com.greedy.dduckleaf.funding.regist.service.FundingRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/funding/regist")
public class FundingRegistController {

    private final FundingRegistService service;

    @Autowired
    public FundingRegistController(FundingRegistService service) {
        this.service = service;
    }

    @GetMapping("/reward/{projectNo}")
    public ModelAndView registFundingChoicePage(ModelAndView mv, @PathVariable int projectNo){

        ProjectDTO fundingInfo = service.findProjectFundingInfo(projectNo);
        mv.addObject("fundingInfo", fundingInfo);
        System.out.println("fundingInfo = " + fundingInfo);
        mv.setViewName("/funding/regist/fundingamount");

        return mv;
    }

    @GetMapping("/shipping")
    public ModelAndView registFundingConfirmPage(ModelAndView mv, FundingRegistDTO registInfo) {

        mv.addObject("registInfo", registInfo);

        System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);System.out.println("registInfo = " + registInfo);
        mv.setViewName("/funding/regist/shippinginfo");

        return mv;
    }
}