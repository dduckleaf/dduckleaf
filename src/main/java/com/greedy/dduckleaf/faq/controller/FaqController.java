package com.greedy.dduckleaf.faq.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/faq")
public class FaqController {


    private final FaqService service;

    @Autowired
    public FaqController(FaqService service) {
        this.service = service;
    }

//    http://localhost:8008/faq/list
//    @GetMapping("/list")
//    public void FaqPage() {}

    @GetMapping("/list")
    public ModelAndView findFaqList(ModelAndView mv, @PageableDefault Pageable pageable){

        System.out.println("pageable= " + pageable);
        Page<FaqDTO> faqList = service.findFaqList(pageable);
        faqList.forEach(System.out::println);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(faqList);

        mv.addObject("faqList", faqList);
        mv.addObject("paging", paging);
        mv.setViewName("faq/list");

        return mv;
    }

}
