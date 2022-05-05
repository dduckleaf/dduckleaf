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

/**
 * <pre>
 * Class : ShippingController
 * Comment : 발송관리 업무에 사용되는 메소드를 작성하였습니다.
 * History
 * 2022/05/06 (조남기) 발송 리워드 정보 조회 구현 시작
 * </pre>
 * @version 1.0.0
 * @author 조남기
 */
@Controller
@RequestMapping("/shipping/management")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    /**
     * endProject : 로그인한 회원의 종료된 프로젝트 정보를 조회합니다.
     * @param projectNo : 프로젝트 번호를 담는 객체
     * @return mv : 브라우저로 전달할 데이터와 브루엊 경로 정보를 저장한 객체
     * @author 조남기
     */
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
