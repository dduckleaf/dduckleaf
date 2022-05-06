package com.greedy.dduckleaf.refund.examine.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.service.RefundingForFarmerExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class : RefundingExamineController
 * Comment :
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

    @GetMapping("/farmer/confirm/{refundNo}")
    public String farmerConfirmRefunding(@PathVariable int refundNo, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        service.confirmRefunding(refundNo, memberNo);

        return "redirect:/refund/find/list/farmer";
    }

    @PostMapping("/farmer/refuse")
    public String farmerRefuseRefunding(RefundingDTO refundingDTO, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        refundingDTO.setMemberNo(memberNo);

        service.refuseRefunding(refundingDTO);

        return "redirect:/refund/find/list/farmer";
    }
    @GetMapping("/platform/objection/{refundingNo}")
    public String platformExamineObjection(@PathVariable int refundingNo) {

        service.registObjection(refundingNo);

        return "redirect:/refund/find/member/detail/" + refundingNo;
    }


}



































