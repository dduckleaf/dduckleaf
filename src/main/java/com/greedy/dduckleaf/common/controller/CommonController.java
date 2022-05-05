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

    /**
     * goToFarmerPage : 로그인 한 파머의 프로젝트 목록 조회 요청 메소드입니다.
     *  @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     *           "/common/farmerpage" : 요약정보를 출력할 브라우저 화면 경로
     */
    @GetMapping("/farmerpage")
    public ModelAndView goToFarmerPage(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        List<ProjectDTO> projectList = shippingService.findProjectListByMemberNo(memberNo);

        mv.addObject("projectList", projectList);
        mv.setViewName("/common/farmerpage");

        return mv;
    }
}
