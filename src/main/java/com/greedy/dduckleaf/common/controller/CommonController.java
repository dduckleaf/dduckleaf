package com.greedy.dduckleaf.common.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import com.greedy.dduckleaf.shippingmanagement.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    private final ShippingService shippingService;

    @Autowired
    public CommonController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/supporterpage")
    public void goToSupporterPage() {}

    @GetMapping("/farmerpage")
    public ModelAndView goToFarmerPage(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        List<ProjectDTO> projectList = shippingService.findProjectListByMemberNo(memberNo);
        System.out.println("projectList = " + projectList);
        mv.addObject("projectList", projectList);
        mv.setViewName("/common/farmerpage");

        return mv;
    }
}
