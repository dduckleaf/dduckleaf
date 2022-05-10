package com.greedy.dduckleaf.funding.regist.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.funding.dto.*;
import com.greedy.dduckleaf.funding.regist.service.FundingRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

        System.out.println("fundingInfo = " + fundingInfo);

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
    public ModelAndView registFundingConfirmPage(ModelAndView mv, FundingRegistDTO registInfo, @AuthenticationPrincipal CustomUser user) {

        FundingRegistInfoDTO fundingRegistInfoDTO = service.findBankAndUserInfo(user.getMemberId(), registInfo.getProjectNo());

        mv.addObject("bankList", fundingRegistInfoDTO.getBankList());
        mv.addObject("member", fundingRegistInfoDTO.getMember());
        mv.addObject("project", fundingRegistInfoDTO.getProject());
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
    public String registByApi(FundingRegistDTO registDTO, @AuthenticationPrincipal CustomUser user) {

        registDTO.setMemberNo(user.getMemberNo());

        System.out.println("registDTO.getShippingAddress() = " + registDTO.getShippingAddress());
        service.registFunding(registDTO);

        return "redirect:/funding/regist/result/" + registDTO.getProjectNo();
    }

    /**
     * sendToFundingResultDetailInfo : 펀딩결제 후 리다이렉트 받는 핸들러메소드입니다.
     * @param projectNo : 결제성공한 해당 펀딩의 번호를 전달받습니다.
     * @return
     *
     * @author 홍성원
     */
    @GetMapping("/result/{projectNo}")
    public ModelAndView sendToFundingResultDetailInfo(ModelAndView mv, @PathVariable int projectNo){

        String endDate = service.findProjetEndDate(projectNo);
        System.out.println("endDate = " + endDate);
        mv.addObject("endDate", endDate);
        mv.setViewName("/funding/regist/fundingresult");

        return mv;
    }

    @PostMapping("/shippingaddress")
    public ModelAndView modifyShippingAddress(ModelAndView mv, ShippingAddressDTO address) {

        service.modifyShippingAddress(address);
        String url = "redirect:/funding/find/detail/member/" + address.getFundingInfoNo();
        mv.setViewName(url);

        return mv;
    }
    @PostMapping("/refundAccount")
    public ModelAndView modifyRefundAccount(ModelAndView mv, FundingDTO accountInfo) {

        service.modifyRefundAccount(accountInfo);

        mv.setViewName("redirect:/funding/find/detail/member/" + accountInfo.getFundingInfoNo());

        return mv;
    }
}
































