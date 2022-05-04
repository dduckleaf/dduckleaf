package com.greedy.dduckleaf.refund.find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : RefundForFindController
 * Comment :
 *
 * History
 * 2022-05-04 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Controller
@RequestMapping("/refund/find")
public class RefundForFindController {

    @GetMapping("/member/list")
    public ModelAndView refundListPage() {

        return new ModelAndView("/refund/find/member/refundlist");
    }

    @GetMapping("/member/detail/{refundNo}")
    public ModelAndView refundDetailPage(ModelAndView mv, @PathVariable int refundNo) {

        mv.setViewName("/refund/find/member/refunddetail");
        return mv;
    }
}
