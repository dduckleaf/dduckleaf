package com.greedy.dduckleaf.main;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final MessageSource messageSource;

    public MainController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value = {"/", "/main"})
    public String mainM() {

        return "main/main";
    }

    @PostMapping(value = "/")
    public ModelAndView redirectMain(ModelAndView mv){

        mv.setViewName("/main/main");

        return mv;
    }
}
