package com.greedy.dduckleaf.projectapplication.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.projectapplication.dto.*;
import com.greedy.dduckleaf.projectapplication.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class: ProjectApplicationController
 * Comment : 프로젝트 오픈 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성 / registProjectApplication 메소드 작성 시작
 * 2022/04/27 (박휘림) projectApplicationMainPage, findProjectNoByFarmerNo, findBasicReqByProjectNo 메소드 작성
 * 2022/04/28 (박휘림) modifyBasicReq, modifyRewardAgreementStatus, findBasicInfoByProjectNo, modifyBasicInfo 메소드 작성
 * 2022/04/29 (박휘림) findStoryByProjectNo, modifyStory, modifyPromotionAgreementStatus, findRewardByProjectNo, modifyReward 메소드 작성
 * 2022/04/30 (박휘림) findPolicyByProjectNo, modifyPolicy, modifyPolicyAgreementStatus, findFarmerInfoByMemberNo, modifyFarmerInfo 메소드 작성
 * </pre>
 * @version 1.0.4
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
        System.out.println("여기 안옴?");
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
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/basicreq")
    public ModelAndView modifyBasicReq(ModelAndView mv, RewardRegistInfoDTO basicreq) {

        projectApplicationService.modifyBasicReq(basicreq);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * modifyRewardAgreementStatus: 사용자가 리워드 관련 서류 제출에 동의 시 동의 여부와 날짜를 업데이트합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/basicreq" 기본 요건 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/rewardagreement")
    public ModelAndView modifyRewardAgreementStatus(ModelAndView mv, RewardRegistInfoDTO basicreq) {

        projectApplicationService.modifyRewardAgreementStatus(basicreq);

        mv.setViewName("redirect:/project/application/basicreq");

        return mv;
    }

    /**
     * findBasicInfoByProjectNo: 기본 정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            basicInfo 기본 정보 기본 데이터
     *            "project/regist/basicinfo" 기본 정보를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicinfo")
    public ModelAndView findBasicInfoByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        ProjectBasicInfoDTO basicInfo = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);

        List<ProjectRewardCategoryDTO> categoryList = projectApplicationService.findAllRewardCategory();

        mv.addObject("categoryList", categoryList);
        mv.addObject("basicInfo", basicInfo);
        mv.setViewName("project/regist/basicinfo");

        return mv;
    }

    /**
     * modifyBasicInfo: 기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicInfo: 사용자가 입력한 기본 정보 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/basicinfo")
    public ModelAndView modifyBasicInfo(ModelAndView mv, ProjectBasicInfoDTO basicInfo) {

        projectApplicationService.modifyBasicInfo(basicInfo);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * findStoryByProjectNo: 스토리 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            story 스토리 기본 데이터
     *            "project/regist/story" 스토리를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/story")
    public ModelAndView findStoryByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        ProjectBasicInfoDTO story = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);

        mv.addObject("story", story);
        mv.setViewName("project/regist/story");

        return mv;
    }

    /**
     * modifyStory: 스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param story: 사용자가 입력한 스토리 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/story")
    public ModelAndView modifyStory(ModelAndView mv, ProjectBasicInfoDTO story) {

        projectApplicationService.modifyStory(story);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * modifyPromotionAgreementStatus: 스토리 페이지에서 사용자가 홍보 심의 동의 시 동의 상태를 변경합니다.
     * @param story: 사용자가 입력한 스토리 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/story" 프로젝트 신청 스토리 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/promotionagreement")
    public ModelAndView modifyPromotionAgreementStatus(ModelAndView mv, ProjectBasicInfoDTO story) {

        projectApplicationService.modifyPromotionAgreementStatus(story);

        mv.setViewName("redirect:/project/application/story");

        return mv;
    }

    /**
     * findRewardByProjectNo: 리워드 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            reward 리워드 정보 기본 데이터
     *            shippingInfo 배송 정보 기본 데이터
     *            "project/regist/reward" 리워드를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/reward")
    public ModelAndView findRewardByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RewardRegistInfoDTO reward = projectApplicationService.findRewardByProjectNo(projectNo);
        ProjectShippingInfoDTO shippingInfo = projectApplicationService.findShippingInfoByProjectNo(projectNo);

        mv.addObject("reward", reward);
        mv.addObject("shippingInfo", shippingInfo);
        mv.setViewName("project/regist/reward");

        return mv;
    }

    /**
     * modifyReward: 스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param reward: 사용자가 입력한 리워드 데이터를 담은 객체
     * @param shippingInfo: 사용자가 입력한 배송 관련 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/reward")
    public ModelAndView modifyReward(ModelAndView mv, RewardRegistInfoDTO reward, ProjectShippingInfoDTO shippingInfo) {

        projectApplicationService.modifyReward(reward, shippingInfo);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * findPolicyByProjectNo: 반환정책 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            policy 정책 기본 데이터
     *            "project/regist/policy" 반환정책을 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/policy")
    public ModelAndView findPolicyByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RefundPolicyDTO policy = projectApplicationService.findPolicyByProjectNo(projectNo);

        mv.addObject("policy", policy);
        mv.setViewName("project/regist/policy");

        return mv;
    }

    /**
     * modifyPolicy: 반환정책 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param policy: 사용자가 입력한 반환정책 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/policy")
    public ModelAndView modifyPolicy(ModelAndView mv, RefundPolicyDTO policy) {
        System.out.println("policy = " + policy);
        projectApplicationService.modifyPolicy(policy);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * modifyPolicyAgreementStatus: 반환정책 페이지에서 사용자가 펀딩금 반환 정책 정보 동의 시 동의 상태를 변경합니다.
     * @param policy: 사용자가 입력한 반환정책 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/policy" 프로젝트 신청 반환정책 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/policyagreement")
    public ModelAndView modifyPolicyAgreementStatus(ModelAndView mv, RefundPolicyDTO policy) {

        projectApplicationService.modifyPolicyAgreementStatus(policy);

        mv.setViewName("redirect:/project/application/policy");

        return mv;
    }

    /**
     * findFarmerInfoByMemberNo: 파머정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            farmerInfo 파머 정보 기본 데이터
     *            homePage 파머 홈페이지 기본 데이터
     *            "project/regist/farmerinfo" 파머정보를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/farmer")
    public ModelAndView findFarmerInfoByMemberNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        FarmerInfoDTO farmerInfo = projectApplicationService.findFarmerInfoByMemberNo(memberNo);

        mv.addObject("farmerInfo", farmerInfo);
        mv.setViewName("project/regist/farmerinfo");

        return mv;
    }

    /**
     * modifyFarmerInfo: 파머정보 작성 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param farmerInfo: 사용자가 입력한 파머정보 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/farmer")
    public ModelAndView modifyFarmerInfo(ModelAndView mv, FarmerInfoDTO farmerInfo) {

        projectApplicationService.modifyFarmerInfo(farmerInfo);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }


}