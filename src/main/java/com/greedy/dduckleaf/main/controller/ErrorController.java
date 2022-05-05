package com.greedy.dduckleaf.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @PostMapping("/login")
    public void loginFailed() {}

    @RequestMapping("denied")
    public void accessDenied() {}
}
