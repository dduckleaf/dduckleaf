package com.greedy.dduckleaf.refund.examine.controller;

import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.service.RefundingForFarmerExamineService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String farmerConfirmRefunding(@PathVariable int refundNo) {

        service.confirmRefunding(refundNo);

        return "redirect:/refund/find/list/farmer";
    }

    @PostMapping("/farmer/refuse")
    public String farmerRefuseRefunding(RefundingDTO refundingDTO) {

        service.refuseRefunding(refundingDTO);
        return "redirect:/refund/find/list/farmer";
    }
}



































