package com.greedy.dduckleaf.main.controller;

import com.greedy.dduckleaf.main.dto.MainPageDTO;
import com.greedy.dduckleaf.main.service.MainService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final MessageSource messageSource;
    private final MainService mainService;

    public MainController(MessageSource messageSource, MainService mainService) {
        this.messageSource = messageSource;
        this.mainService = mainService;
    }

    @GetMapping(value = {"/", "/main"})
    public ModelAndView mainM(ModelAndView mv) {

        MainPageDTO mainPage = mainService.findMainPage();

        mv.addObject("dduckleafRecommendList", mainPage.getDduckleafRecommendList());
        mv.addObject("rankingList", mainPage.getRankingList());
        mv.setViewName("main/mainPage");

        return mv;
    }

    @PostMapping(value = "/")
    public ModelAndView redirectMain(ModelAndView mv){

        System.out.println("여기오나??!??!");

        mv.setViewName("/main/mainPage");

        return mv;
    }

    @RequestMapping(value = "/dashboard")
    public String sendDB() {

        return "/admin/dashboard";
    }
}
