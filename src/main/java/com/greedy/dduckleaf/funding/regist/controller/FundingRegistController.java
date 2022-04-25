package com.greedy.dduckleaf.funding.regist.controller;

import com.greedy.dduckleaf.funding.dto.BankListAndMemberDTO;
import com.greedy.dduckleaf.funding.dto.FundingRegistDTO;
import com.greedy.dduckleaf.funding.dto.ProjectDTO;
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
        mv.setViewName("/funding/regist/fundingamount");

        System.out.println("##1");
        System.out.println("fundingInfo = " + fundingInfo);
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

        System.out.println("##2");
        System.out.println("fundingInfo = " + registInfo);
        return mv;
    }

    //redirect로 만들고 상세페이지 요청 핸들러메소드 따로 만들것. 펀딩번호를 PathVariable로 보내서..
    @GetMapping("/fundinginfo")
    public String registByApi(FundingRegistDTO registDTO) {
        registDTO.setProjectNo(1);
        registDTO.setMemberNo(5);
        service.registFunding(registDTO);

        System.out.println("##3");
        System.out.println("fundingInfo = " + registDTO);

        return "redirect:/funding/regist/result/14";
    }



    /**
     * sendToFundingResultDetailInfo : 펀딩결제 후 리다이렉트 받는 핸들러메소드.
     * @param fundingNo : 결제성공한 해당 펀딩의 번호를 전달받는다.
     * @return
     *
     * @author 홍성원
     */
    @GetMapping("/result/{fundingNo}")
    public ModelAndView sendToFundingResultDetailInfo(ModelAndView mv, @PathVariable int fundingNo){

//        java.sql.Date endDate = service.findProjectEndDate(fundingNo);

//        mv.addObject("endDate", endDate);
        mv.setViewName("/funding/regist/fundingresult");

        return mv;
    }



    /**
     * redirectFundingListPage :
     * @param
     * @return
     *
     * @author 홍성원
     */
    @GetMapping("/list/member")
    public String redirectFundingListPage() {

        return "redirect:/funding/list/member";
    }


}































