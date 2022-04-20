package com.greedy.dduckleaf.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/supporterpage")
    public void goToSupporterPage() {}

    @GetMapping("/farmerpage")
    public void goToFarmerPage() {}
}
