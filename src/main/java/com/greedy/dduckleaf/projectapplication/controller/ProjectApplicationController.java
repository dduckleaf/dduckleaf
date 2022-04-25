package com.greedy.dduckleaf.projectapplication.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class: ProjectApplicationController
 * Comment : 프로젝트 오픈 싱청
 * History
 * 2022/04/25 (박휘림) 처음 작성 / 프로젝트 오픈 신청 시 관련 테이블에 기본값 인서트 메소드 작성 시작 / 기본 요건 페이지 조회
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
@Controller
@RequestMapping("/project/application")
public class ProjectApplicationController {

    private final ProjectApplicationService projectApplicationService;

    @Autowired
    public ProjectApplicationController(ProjectApplicationService projectApplicationService) {
        this.projectApplicationService = projectApplicationService;
    }

    @GetMapping("/basicreq")
    public ModelAndView findBasicReqByProjectNo(ModelAndView mv, int projectNo) {

        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);

        mv.addObject("basicReq", basicReq);
        mv.setViewName("/project/regist/basicreq");

        return mv;
    }

    public int findProjectNoByFarmerNo(@AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        int projectNo = projectApplicationService.findProjectNoByFarmerId(farmerNo);

        return projectNo;
    }

    @PostMapping("/basicreq")
    public ModelAndView registBasicReq(ModelAndView mv, RewardRegistInfoDTO basicreq) {

        projectApplicationService.modifyBasicReq(basicreq);

        mv.setViewName("redirect:/project/regist/main");

        return mv;
    }
}
