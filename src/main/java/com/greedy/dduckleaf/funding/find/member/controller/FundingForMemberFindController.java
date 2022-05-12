package com.greedy.dduckleaf.funding.find.member.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.funding.dto.FundingByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.find.member.dto.FundingFindDetailInfoForMemberDTO;
import com.greedy.dduckleaf.funding.find.member.dto.FundingInfoByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.find.member.service.FundingServiceForFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : FundingForMemberFindController
 * Comment : 회원의 펀딩 조회를 담당하는 핸들러메소드를 정의해놓은 클래스
 *
 * History
 * 2022-04-25 (홍성원) 처음 작성 / sendMemberFundingListPage / findFundingListByMemberNo 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author (홍성원)
 */
@Controller
@RequestMapping("/funding/find")
public class FundingForMemberFindController {

    private final int BUTTON_AMOUNT = 5;
    /* 회원의 펀딩조희 프로세스의 로직을 처리하는 서비스 계층의 인스턴스 변수를 선언한다. */
    private final FundingServiceForFind service;

    @Autowired
    public FundingForMemberFindController(FundingServiceForFind service) {

        this.service = service;
    }

    /**
     * findFundingListByMemberNo : 회원번호를 이용해 해당 회원의 펀딩목록을 조회합니다.
     *
     * @param user : 회원번호를 이용하기위해 CustomUser 인스턴스를 전달받습니다.
     * @return fundingList : 해당 회원의 펀딩목록을 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/list/member")
    public ModelAndView findFundingListByMemberNo(ModelAndView mv, @PageableDefault Pageable pageable, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        Page<FundingDTO> fundingList = service.findFundingByMemberNo(memberNo, pageable);

        /* 한 페이지에 표시할 버튼의 개수를 설정합니다. */
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(fundingList, BUTTON_AMOUNT);

        mv.addObject("fundingList", fundingList);
        mv.addObject("paging", paging);

        mv.setViewName("/funding/find/supporter/fundinglist");

        return mv;
    }

    /**
     * sendMemberFundingListPage : 회원의 펀딩내역 페이지로 포워딩합니다.
     *
     * @author 홍성원
     */
    @GetMapping("/detail/member/{fundingNo}")
    public ModelAndView sendMemberFundingListPage(ModelAndView mv, @PathVariable int fundingNo) {

        FundingFindDetailInfoForMemberDTO fundingDetailInfo = service.findFundingInfo(fundingNo);

        mv.addObject("addressInfo", fundingDetailInfo.getShippingAddress());
        mv.addObject("funding", fundingDetailInfo.getFunding());
        mv.addObject("bankList", fundingDetailInfo.getBankList());
        mv.setViewName("/funding/find/supporter/fundingdetailinfo");

        return mv;
    }

    /**
     * sendFundingMemberListAdminPage : 회원 별 펀딩 개수를 조회하는 페이지로 이동합니다.
     *
     * @author 홍성원
     */
    @GetMapping("/admin/memberlist")
    public ModelAndView sendFundingMemberListAdminPage(ModelAndView mv, @PageableDefault Pageable pageable) {

        int buttonAmount = 5;
        Page<FundingInfoByMemberForAdminDTO> fundingInfos = service.findfundingInfoByMemberForAdmin(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(fundingInfos, buttonAmount);

        mv.addObject("paging", paging);
        mv.addObject("fundingInfos", fundingInfos);
        mv.setViewName("/funding/find/admin/memberfundinglist");

        return mv;
    }

    /**
     * sendFundingMemberDetailAdminPage : 회원의 펀딩이력을 조회하는 페이지로 이동합니다.
     *
     * @author 홍성원
     */
    @GetMapping("/admin/memberlist/detail/{memberNo}")
    public ModelAndView sendFundingMemberDetailAdminPage(ModelAndView mv, @PathVariable int memberNo, @PageableDefault Pageable pageable) {

        Page<FundingByMemberForAdminDTO> fundings = service.findFundingInfoByMemberId(memberNo, pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(fundings, 5);

        mv.addObject("paging", paging);
        mv.addObject("fundings", fundings);
        mv.addObject("memberNo", memberNo);
        mv.setViewName("/funding/find/admin/memberfundingdetail");

        return mv;
    }

    @GetMapping("/admin/memberdetail/{fundingNo}")
    public ModelAndView findMemberDetail(ModelAndView mv, @PathVariable int fundingNo) {

        FundingFindDetailInfoForMemberDTO fundingDetailInfo = service.findFundingInfo(fundingNo);

        mv.addObject("addressInfo", fundingDetailInfo.getShippingAddress());
        mv.addObject("funding", fundingDetailInfo.getFunding());
        mv.addObject("bankList", fundingDetailInfo.getBankList());
        mv.setViewName("/funding/find/admin/fundingdetailinfo");

        return mv;
    }
}