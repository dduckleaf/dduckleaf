package com.greedy.dduckleaf.mockfund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mockfund")
public class MockFundController {

    @GetMapping("mockfundmain")
    public void mockFundMain() {}

    @GetMapping("regist/basicinfo")
    public void mockFundBasicInfo() {}

    @GetMapping("regist/story")
    public void mockFundStory() {}

}
