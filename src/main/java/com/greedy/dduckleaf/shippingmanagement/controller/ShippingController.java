package com.greedy.dduckleaf.shippingmanagement.controller;

import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import com.greedy.dduckleaf.shippingmanagement.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shipping/management")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/default/{projectNo}")
    public ModelAndView endProject(ModelAndView mv, @PathVariable int projectNo) {

        List<ProjectDTO> project = shippingService.findProjectListByMemberNo(projectNo);

        mv.addObject("endProjectList", project);
        mv.setViewName("/shipping/list");

        return mv;
    }

    @GetMapping("/notshipped")
    public ModelAndView notShippedReward(ModelAndView mv, @PathVariable int projectNo) {



        mv.setViewName("/shipping/notlist");

        return mv;
    }

}
