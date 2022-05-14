package com.greedy.dduckleaf.refund.regist.controller;

import com.greedy.dduckleaf.refund.regist.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.regist.service.RefundingRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : RefundingRegistController
 * Comment : 환불 등록
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

    private final RefundingRegistService service;

    @Autowired
    public RefundingRegistController(RefundingRegistService service) {
        this.service = service;
    }

    /**
     * sendToRefundRegist : 환불 정보를 등록합니다.
     * @param refundingInfo : 환불 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @PostMapping(value = "/refundregist")
    public ModelAndView sendToRefundRegist(ModelAndView mv, RefundingDTO refundingInfo) {

        service.registRefunding(refundingInfo);

        mv.setViewName("redirect:/refund/find/member/list");

        return mv;
    }
}