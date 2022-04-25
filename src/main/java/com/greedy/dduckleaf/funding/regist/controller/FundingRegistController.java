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

    /* 빈으로 등록된 서비스 인스턴스를 의존성 주입 받습니다. */
    private final FundingRegistService service;

    @Autowired
    public FundingRegistController(FundingRegistService service) {
        this.service = service;
    }

    /**
     * registFundingChoicePage : 펀딩신청 정보를 조회해, 펀딩신청 첫 화면으로 포워딩하는 핸들러메소드입니다.
     * @param projectNo : 프로젝트 번호를 전달받습니다.
     * @return fundingInfo : 프로젝트의 펀딩을 위한 리워드, 배송비정보가 담긴 DTO를 반환합니다.
     *
     * @author 홍성원
     */
    @GetMapping("/reward/{projectNo}")
    public ModelAndView registFundingChoicePage(ModelAndView mv, @PathVariable int projectNo){

        ProjectDTO fundingInfo = service.findProjectFundingInfo(projectNo);

        mv.addObject("fundingInfo", fundingInfo);
        mv.setViewName("/funding/regist/fundingamount");

        return mv;
    }

    /**
     * registFundingConfirmPage : 펀딩신청의 배송지 입력 및 환불계좌 입력 페이지로 포워딩하는 핸들러메소드입니다.
     * @param registInfo : 회원이 입력한 펀딩금액에 관한 정보를 전달받습니다.
     * @return bankList : 은행목록을 반환합니다.
     * @return member : 펀딩신청하는 회원의 정보를 반환합니다.
     * @return registInfo : 회원이 입력한 펀딩금액에 관한 정보를 반환합니다.
     *
     * @author 홍성원
     */
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



    /**
     * registByApi : 결제 된 펀딩결과를 저장 후 펀딩결과화면으로 리다이렉트하는 핸들러메소드입니다.
     * @param
     * @return
     *
     * @author 홍성원
     */
    @GetMapping("/fundinginfo")
    public String registByApi(FundingRegistDTO registDTO) {

        registDTO.setProjectNo(1);
        registDTO.setMemberNo(5);

        service.registFunding(registDTO);

        return "redirect:/funding/regist/result/14";
    }

    /**
     * sendToFundingResultDetailInfo : 펀딩결제 후 리다이렉트 받는 핸들러메소드입니다.
     * @param fundingNo : 결제성공한 해당 펀딩의 번호를 전달받습니다.
     * @return
     *
     * @author 홍성원
     */
    @GetMapping("/result/{fundingNo}")
    public ModelAndView sendToFundingResultDetailInfo(ModelAndView mv, @PathVariable int fundingNo){

        mv.setViewName("/funding/regist/fundingresult");

        return mv;
    }
}