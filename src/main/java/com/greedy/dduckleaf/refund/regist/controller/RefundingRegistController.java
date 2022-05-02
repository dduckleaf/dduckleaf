package com.greedy.dduckleaf.refund.regist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/refundregist/{fundingNo}")
    public ModelAndView sendToRefundRegist(ModelAndView mv, @PathVariable int fundingNo) {

        mv.addObject("fundingNo", fundingNo);
        mv.setViewName("/refund/regist/refundregist");

        return mv;
    }
}
