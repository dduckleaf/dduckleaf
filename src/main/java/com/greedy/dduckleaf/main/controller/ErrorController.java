package com.greedy.dduckleaf.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @PostMapping("/login")
    public ModelAndView loginFailed(ModelAndView mv, RedirectAttributes rttr) {

        rttr.addFlashAttribute("message", "아이디 혹은 비밀번호를 확인해주세요.");
        mv.setViewName("redirect:/member/login");
        return mv;
    }

    @RequestMapping("denied")
    public void accessDenied() {}
}
