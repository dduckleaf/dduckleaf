package com.greedy.dduckleaf.main;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final MessageSource messageSource;

    public MainController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value = {"/", "/main"})
    public String mainM() {

        System.out.println("여기오낭");

        return "main/mainPage";
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
