package com.greedy.dduckleaf.refund.examine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/farmer/confirm")
    public String farmerConfirmRefunding() {

        return "redirect:/refund/find/list/farmer";
    }

    @GetMapping("/farmer/refuse")
    public String farmerRefuseRefunding() {

        return "redirect:/refund/find/list/farmer";
    }



}



































