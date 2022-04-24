package com.greedy.dduckleaf.funding.regist.controller;

import com.greedy.dduckleaf.funding.regist.dto.BankListAndMemberDTO;
import com.greedy.dduckleaf.funding.regist.dto.FundingRegistDTO;
import com.greedy.dduckleaf.funding.regist.dto.ProjectDTO;
import com.greedy.dduckleaf.funding.regist.service.FundingRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : FundingRegistController
 * Comment : 서포터의 펀딩 신청 프로세스를 담당하는 컨트롤러.
 * History
 * 2022/04/18 : registFundingChoicePage 메소드 작성.
 * 2022/04/20 : registFundingConfirmPage 메소드 작성.
 * </pre>
 * @version 1.0.1
 * @author 홍성원
 */
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

        String memberId = "USER01";
        BankListAndMemberDTO bankListAndMember = service.findBankAndUserInfo(memberId);

        mv.addObject("bankList", bankListAndMember.getBankList());
        mv.addObject("member", bankListAndMember.getMember());
        mv.addObject("registInfo", registInfo);


        mv.setViewName("/funding/regist/shippinginfo");

        return mv;
    }

    @PostMapping("/fundinginfo")
    public String registByApi(FundingRegistDTO registDTO) {
        registDTO.setProjectNo(1);
        registDTO.setMemberNo(5);
        service.registFunding(registDTO);

        return "redirect:/funding/regist/reward/1";
    }
}