package com.greedy.dduckleaf.faq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("faq")
public class FaqController {

//    @Autowired
//    private final FaqService service;

//  http://localhost:8008/faq/list
    @GetMapping("list")
    public void FaqPage() {}

//    http://localhost:8008/faq/detail
    @GetMapping("detail")
    public void FaqDetailPage() {}


//    @GetMapping("/faq")
//    public ModelAndView FaqPage(ModelAndView mv) {
//
//
//        return mv;
//    }

}
