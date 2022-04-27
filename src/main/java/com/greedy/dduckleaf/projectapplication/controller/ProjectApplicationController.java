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

    /**
     * registProjectApplication: 프로젝트 신청 버튼 클릭 시 기본데이터를 인서트합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "project/regist/main" 프로젝트 신청 메인페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/regist")
    public ModelAndView registProjectApplication(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        projectApplicationService.registProjectApplication(farmerNo);

        mv.setViewName("project/regist/main");

        return mv;
    }

    /**
     * projectApplicationMainPage: 프로젝트 신청 페이지로 이동합니다.
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "project/regist/main" 프로젝트 신청 메인페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/goMain")
    public ModelAndView projectApplicationMainPage(ModelAndView mv) {

        mv.setViewName("project/regist/main");
        return mv;
    }

    /**
     * findProjectNoByFarmerNo: 회원번호로 프로젝트 번호를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return projectNo 프로젝트 번호
     * @author 박휘림
     */
    public int findProjectNoByFarmerNo(@AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        int projectNo = projectApplicationService.findProjectNoByFarmerId(farmerNo);

        return projectNo;
    }

    /**
     * findBasicReqByProjectNo: 기본 요건 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            basicReq 기본 요건 기본 데이터
     *            "project/regist/basicreq" 기본 요건을 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicreq")
    public ModelAndView findBasicReqByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);
        System.out.println("basicReq = " + basicReq);

        mv.addObject("basicReq", basicReq);
        mv.setViewName("project/regist/basicreq");

        return mv;
    }

    /**
     * modifyBasicReq: 기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/regist/main" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/basicreq")
    public ModelAndView modifyBasicReq(ModelAndView mv, RewardRegistInfoDTO basicreq) {
        System.out.println("basicreq = " + basicreq);
        projectApplicationService.modifyBasicReq(basicreq);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    @PostMapping("/rewardagreement")
    public ModelAndView modifyRewardAgreementStatus(ModelAndView mv, RewardRegistInfoDTO basicreq) {

        projectApplicationService.modifyRewardAgreementStatus(basicreq);
        System.out.println("basicreq = " + basicreq);

        mv.setViewName("redirect:/project/application/basicreq");

        return mv;
    }
}
