package com.greedy.dduckleaf.refund.regist.controller;

import com.greedy.dduckleaf.refund.regist.dto.RefundingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : RefundingRegistController
 * Comment :
 *
 * History
 * 2022-05-02 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Controller
@RequestMapping("/refund/regist")
public class RefundingRegistController {

    @PostMapping(value = "/refundregist")
    public ModelAndView sendToRefundRegist(ModelAndView mv, RefundingDTO refundingInfo) {

        System.out.println("refundingInfo = " + refundingInfo);System.out.println("refundingInfo = " + refundingInfo);System.out.println("refundingInfo = " + refundingInfo);System.out.println("refundingInfo = " + refundingInfo);

        mv.setViewName("redirect:/");

        return mv;
    }
}
