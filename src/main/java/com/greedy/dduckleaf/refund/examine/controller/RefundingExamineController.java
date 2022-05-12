package com.greedy.dduckleaf.refund.examine.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.refund.examine.dto.RefundObjectionHistoryDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingObjectionDTO;
import com.greedy.dduckleaf.refund.examine.entity.RefundingObjection;
import com.greedy.dduckleaf.refund.examine.service.RefundingForFarmerExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : RefundingExamineController
 * Comment : 환불 심사
 *
 * History
 * 2022-05-05 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Controller
@RequestMapping("/refund/examine")
public class RefundingExamineController {

    @Autowired
    private RefundingForFarmerExamineService service;

    /**
     * farmerConfirmRefunding : 환불 승인요청을 받아 서비스 호출 후 파머 페이지로 포워딩합니다.
     * @param refundNo : 환불 번호를 전달받습니다.
     * @return : 포워딩 경로를 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/farmer/confirm/{refundNo}")
    public String farmerConfirmRefunding(@PathVariable int refundNo, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        service.confirmRefunding(refundNo, memberNo);

        return "redirect:/refund/find/list/farmer";
    }

    /**
     * farmerRefuseRefunding : 환불 거절 요청을 받아 서비스 호출 후 포워딩 url을 반환합니다.
     * @param refundingDTO : 환불 번호와 거절 사유를 담은 변수를 전달받습니다.
     * @return 포워딩 경로를 반환합니다.
     * @author 홍성원
     */
    @PostMapping("/farmer/refuse")
    public String farmerRefuseRefunding(RefundingDTO refundingDTO, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        refundingDTO.setMemberNo(memberNo);

        service.refuseRefunding(refundingDTO);

        return "redirect:/refund/find/list/farmer";
    }

    /**
     * platformExamineObjection : 서포터의 이의신청 요청을 받아 서비스 호출 후 포워딩 경로를 반환합니다.
     * @param refundingNo : 환불번호를 전달받습니다.
     * @return 포워딩 경로를 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/platform/objection/{refundingNo}")
    public String platformExamineObjection(@PathVariable int refundingNo) {

        service.registObjection(refundingNo);

        return "redirect:/refund/find/member/detail/" + refundingNo;
    }

    /**
     * platformExamineObjection : 서포터의 이의신청 요청을 받아 서비스 호출 후 포워딩 경로를 반환합니다.
     * @return objections : 이의신청 정보를 반환합니다.
     * @author 홍성원
     */
    @GetMapping("/platform/objection/list")
    public ModelAndView platformObjectionListPage(ModelAndView mv,
                                                  @PageableDefault(size=10, sort="refundObjectionNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<RefundingObjectionDTO> objections = service.findObjectionList(pageable);

        mv.addObject("objections", objections);

        return mv;
    }

    /**
     * examineObjectionconfirm : 플랫폼이 조회한 이의신청을 승인합니다.
     * @param refundingNo : 환불 번호를 전달받습니다.
     *
     * @author 홍성원
     */
    @GetMapping("/platform/objection/confirm/{refundingNo}")
    public ModelAndView examineObjectionconfirm(ModelAndView mv, @PathVariable int refundingNo, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        /* 전달받은 펀딩번호와 로그인중인 관리자 번호를 전달합니다. */
        service.examineObjectionconfirm(refundingNo, memberNo);

        mv.setViewName("redirect:/refund/find/admin/statuslist/1");
        return mv;
    }

    /**
     * examineObjectionRefuse : 플랫폼이 조회한 이의신청을 거절합니다.
     * @param objectionHistoryDTO : 이의신청 거절 사유와, 환불요청 번호를 담은 자료형을 전달받습니다.
     *
     * @author 홍성원
     */
    @PostMapping("/platform/objection/refuse")
    public ModelAndView examineObjectionRefuse(ModelAndView mv, RefundObjectionHistoryDTO objectionHistoryDTO, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        service.examineObjectionRefuse(objectionHistoryDTO, memberNo);
        mv.setViewName("redirect:/refund/find/admin/statuslist/1");

        return mv;
    }
}