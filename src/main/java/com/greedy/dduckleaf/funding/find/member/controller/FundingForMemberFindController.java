package com.greedy.dduckleaf.funding.find.member.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.funding.dto.FundingByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.RefundingFindDetailInfoDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.find.member.dto.FundingFindDetailInfoForMemberDTO;
import com.greedy.dduckleaf.funding.find.member.dto.FundingInfoByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.find.member.dto.ProjectManageFundingDTO;
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
 * 2022-05-07 (홍성원) sendFundingMemberListAdminPage / sendFundingMemberDetailAdminPage / findMemberDetail 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author (홍성원)
 */
@Controller
@RequestMapping("/funding/find")
public class FundingForMemberFindController {

    /* 버튼의 개수를 상수필드로 선언 및 초기화합니다. */
    private final int BUTTON_AMOUNT = 5;
    /* 회원의 펀딩조희 프로세스의 로직을 처리하는 서비스 계층의 인스턴스 변수를 선언합니다. */
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

        /* 조회해온 펀딩목록과 페이징 정보를 모델에 저장 후 출력 페이지로 반환합니다. */
        mv.addObject("fundingList", fundingList);
        mv.addObject("paging", paging);
        mv.addObject("fundingSize", fundingList != null ?fundingList.getTotalPages(): 0);
        mv.setViewName("/funding/find/supporter/fundinglist");

        return mv;
    }

    /**
     * sendMemberFundingListPage : 회원의 펀딩내역 페이지로 포워딩합니다.
     * @param fundingNo : 펀딩 번호를 전달받습니다.
     * @return addressInfo : 회원의 펀딩 신청 시 작성했던 배송지 정보를 반환합니다.
     * @return funding : 회원의 펀딩번호에 해당하는 펀딩 정보를 반환합니다.
     * @return bankList : 환불 계좌번호를 수정할 때 선택 할 은행 목록을 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/detail/member/{fundingNo}")
    public ModelAndView sendMemberFundingListPage(ModelAndView mv, @PathVariable int fundingNo) {

        /* 펀딩 번호로, 해당 번호의 정보를 조회합니다. */
        FundingFindDetailInfoForMemberDTO fundingDetailInfo = service.findFundingInfo(fundingNo);

        /* 조회해온 주소지, 펀딩정보, 은행목록 정보를 모델에 저장 후 반환합니다. */
        mv.addObject("addressInfo", fundingDetailInfo.getShippingAddress());
        mv.addObject("funding", fundingDetailInfo.getFunding());
        mv.addObject("bankList", fundingDetailInfo.getBankList());
        mv.setViewName("/funding/find/supporter/fundingdetailinfo");

        return mv;
    }

    /**
     * sendFundingMemberListAdminPage : 회원 별 펀딩 개수를 조회하는 페이지로 이동합니다.
     * @return fundingInfos : 회원별 펀딩정보를 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/admin/memberlist")
    public ModelAndView sendFundingMemberListAdminPage(ModelAndView mv, @PageableDefault Pageable pageable) {

        /* 회원별 펀딩개수 및 펀딩정보를 조회합니다. */
        Page<FundingInfoByMemberForAdminDTO> fundingInfos = service.findfundingInfoByMemberForAdmin(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(fundingInfos, BUTTON_AMOUNT);

        /* 펀딩정보와 페이징 정보를 저장 후 반환합니다. */
        mv.addObject("paging", paging);
        mv.addObject("fundingInfos", fundingInfos);
        mv.setViewName("/funding/find/admin/memberfundinglist");

        return mv;
    }

    /**
     * sendFundingMemberDetailAdminPage : 회원의 펀딩이력을 조회하는 페이지로 이동합니다.
     * @Param memberNo : 회원번호를 전달받습니다.
     * @return fundings : 회원의 펀딩기록을 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/admin/memberlist/detail/{memberNo}")
    public ModelAndView sendFundingMemberDetailAdminPage(ModelAndView mv, @PathVariable int memberNo, @PageableDefault Pageable pageable) {

        /* 한 회원의 펀딩기록을 조회합니다. */
        Page<FundingByMemberForAdminDTO> fundings = service.findFundingInfoByMemberId(memberNo, pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(fundings, BUTTON_AMOUNT);

        /* 펀딩정보와 회원번호, 페이징 정보를 저장 후 반환합니다. */
        mv.addObject("paging", paging);
        mv.addObject("fundings", fundings);
        mv.addObject("memberNo", memberNo);
        mv.setViewName("/funding/find/admin/memberfundingdetail");

        return mv;
    }
    /**
     * findMemberDetail : 회원의 펀딩 상세내역을 조회합니다.
     * @Param fundingNo : 펀딩번호를 전달받습니다.
     * @return funding : 회원의 펀딩기록을 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/admin/memberdetail/{fundingNo}")
    public ModelAndView findMemberDetail(ModelAndView mv, @PathVariable int fundingNo) {

        /* 전달받은 펀딩번호에 해당하는 정보를 조회합니다. */
        FundingFindDetailInfoForMemberDTO fundingDetailInfo = service.findFundingInfo(fundingNo);

        /* 펀딩화면에 출력할 주소지정보와 은행정보, 펀딩 상세내역을 저장 후 반환합니다. */
        mv.addObject("addressInfo", fundingDetailInfo.getShippingAddress());
        mv.addObject("funding", fundingDetailInfo.getFunding());
        mv.addObject("bankList", fundingDetailInfo.getBankList());
        mv.setViewName("/funding/find/admin/fundingdetailinfo");

        return mv;
    }

    @GetMapping("/endproject/{projectNo}")
    public ModelAndView findFundingListEndProject(ModelAndView mv, @PathVariable int projectNo, @PageableDefault Pageable pageable) {

        ProjectManageFundingDTO manageDTO = service.findFundingInfoByProjectNo(projectNo, pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(manageDTO.getFundingInfos(), BUTTON_AMOUNT);

        /* 펀딩정보와 회원번호, 페이징 정보를 저장 후 반환합니다. */
        mv.addObject("paging", paging);
        mv.addObject("fundingInfos", manageDTO.getFundingInfos());
        mv.addObject("project", manageDTO.getProject());
        mv.setViewName("/funding/find/admin/projectfundingmanage");

        return mv;
    }
    @GetMapping("/endproject/detail/{fundingNo}")
    public ModelAndView findFundingDetailEndProject(ModelAndView mv, @PathVariable int fundingNo) {

        /* 펀딩 번호로, 해당 번호의 정보를 조회합니다. */
        FundingFindDetailInfoForMemberDTO fundingDetailInfo = service.findFundingInfo(fundingNo);

        /* 조회해온 주소지, 펀딩정보, 은행목록 정보를 모델에 저장 후 반환합니다. */
        mv.addObject("addressInfo", fundingDetailInfo.getShippingAddress());
        mv.addObject("funding", fundingDetailInfo.getFunding());
        mv.addObject("bankList", fundingDetailInfo.getBankList());
        mv.addObject("project", fundingDetailInfo.getFunding().getProject());
        mv.setViewName("/funding/find/admin/projectfundingmanagedetail");

        return mv;
    }

    @GetMapping("/admin/refunding/projectlist/{projectNo}")
    public ModelAndView findNotFundingRefunding(ModelAndView mv, @PathVariable int projectNo, @PageableDefault Pageable pageable) {

        RefundingFindDetailInfoDTO info = service.findRefudingInfo(projectNo, pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(info.getRefundings(), BUTTON_AMOUNT);

        /* 펀딩정보와 회원번호, 페이징 정보를 저장 후 반환합니다. */
        mv.addObject("paging", paging);
        mv.addObject("project", info.getProject());
        mv.addObject("refundings", info.getRefundings());

        mv.setViewName("/refund/find/admin/projectrefundmanage");

        return mv;
    }
}