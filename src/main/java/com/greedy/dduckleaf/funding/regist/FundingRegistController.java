package com.greedy.dduckleaf.funding.regist;

import com.greedy.dduckleaf.funding.regist.dto.ProjectForFundingRegistDTO;
import com.greedy.dduckleaf.funding.regist.service.FundingRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funding/regist")
public class FundingRegistController {
    private final FundingRegistService service;

    @Autowired
    public FundingRegistController(FundingRegistService service) {
        this.service = service;
    }


    @GetMapping("/amount/{projectNo}")
    public ModelAndView registFundingPage(ModelAndView mv, @PathVariable int projectNo){

        ProjectForFundingRegistDTO fundingInfo = service.findProjectFundingInfo(projectNo);
        mv.addObject("fundingInfo", fundingInfo);
        mv.setViewName("/funding/regist");

        return mv;
    }

}
