package com.greedy.dduckleaf.faq.controller;

import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    private final FaqService service;

    public FaqController(FaqService service) {
        this.service = service;
    }

//    http://localhost:8008/faq/list
//    @GetMapping("/list")
//    public void FaqPage() {}

    @GetMapping("/list")
    public ModelAndView findFaqList(ModelAndView mv, @PathVariable int faqNo){

        FaqDTO faq = service.findfaqlist(faqNo);

        mv.addObject("FAQInfo", faq);
        mv.setViewName("faq/list");

        return mv;
    }

}
