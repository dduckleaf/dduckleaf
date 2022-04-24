package com.greedy.dduckleaf.funding.find.member.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.find.member.service.FundingServiceForFind;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : FundingForMemberFindController
 * Comment : 회원의 펀딩 조회를 담당하는 핸들러메소드를 정의해놓은 클래스 입니다.
 *
 * History
 * 2022-04-25 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@Controller
@RequestMapping("/funding/find")
public class FundingForMemberFindController {

    private final FundingServiceForFind service;

    public FundingForMemberFindController(FundingServiceForFind service) {
        this.service = service;
    }


    /**
     * 회원번호를 이용해 해당 회원의 펀딩목록을 조회합니다.
     *
     * @param user : 회원번호를 이용하기위해 CustomUser 인스턴스를 전달받습니다.
     * @return fundingList : 해당 회원의 펀딩목록을 반환합니다.
     */
    @GetMapping("/list/member")
    public ModelAndView findFundingListByMemberNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        List<FundingDTO> fundingList = service.findFundingByMemberNo(memberNo);

        mv.addObject("fundingList", fundingList);
        mv.setViewName("/funding/find/supporter/fundinglist");

        return mv;
    }
}







































