//package com.greedy.dduckleaf.funding.find.member.controller;
//
//import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
//import com.greedy.dduckleaf.funding.dto.FundingDTO;
//import com.greedy.dduckleaf.funding.find.member.service.FundingServiceForFind;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
///**
// * <pre>
// * Class : FundingForMemberFindController
// * Comment : 회원의 펀딩 조회를 담당하는 핸들러메소드를 정의해놓은 클래스
// *
// * History
// * 2022-04-25 (홍성원) 처음 작성 / sendMemberFundingListPage / findFundingListByMemberNo 메소드 작성
// * </pre>
// * @version 1.0.0
// * @author (홍성원)
// */
//@Controller
//@RequestMapping("/funding/find")
//public class FundingForMemberFindController {
//
//    /* 회원의 펀딩조희 프로세스의 로직을 처리하는 서비스 계층의 인스턴스 변수를 선언한다. */
//    private final FundingServiceForFind service;
//
//    @Autowired
//    public FundingForMemberFindController(FundingServiceForFind service) {
//
//        this.service = service;
//    }
//
//    /**
//     * sendMemberFundingListPage : 회원의 펀딩목록 페이지로 포워딩합니다.
//     *
//     * @author 홍성원
//     */
//    @GetMapping("/detail/member")
//    public ModelAndView sendMemberFundingListPage(ModelAndView mv) {
//
//        mv.setViewName("/funding/find/supporter/fundingdetailinfo");
//
//        return mv;
//    }
//
//    /**
//     * findFundingListByMemberNo : 회원번호를 이용해 해당 회원의 펀딩목록을 조회합니다.
//     *
//     * @param user : 회원번호를 이용하기위해 CustomUser 인스턴스를 전달받습니다.
//     * @return fundingList : 해당 회원의 펀딩목록을 반환합니다.
//     * @author 홍성원
//     */
//    @GetMapping("/list/member")
//    public ModelAndView findFundingListByMemberNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {
//
//        int memberNo = user.getMemberNo();
//        List<FundingDTO> fundingList = service.findFundingByMemberNo(memberNo);
//        fundingList.forEach(fundingDTO -> {
//            System.out.println("fundingDTO = " + fundingDTO);
//            System.out.println();
//        });
//        mv.addObject("fundingList", fundingList);
//        mv.setViewName("/funding/find/supporter/fundinglist");
//
//        return mv;
//    }
//}