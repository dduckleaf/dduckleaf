package com.greedy.dduckleaf.shippingmanagement.controller;

import com.greedy.dduckleaf.shippingmanagement.dto.FundingInfoDTO;
import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import com.greedy.dduckleaf.shippingmanagement.dto.RewardShippingStatusDTO;
import com.greedy.dduckleaf.shippingmanagement.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : ShippingController
 * Comment : 발송관리 업무에 사용되는 메소드를 작성하였습니다.
 * History
 * 2022/05/06 (조남기) 발송 리워드 정보 조회 구현 시작
 * 2022/05/07 (조남기) 발송 리워드 정보 조회 구현 완료, 발송 리워드 정보 상세 조회 구현 시작
 * 2022/05/08 (조남기) 발송 리워드 정보 상세 조회 구현 완료, 발송 상태변경 구현 시작
 * </pre>
 * @version 1.0.2
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
     * @return mv : 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 조남기
     */
    @GetMapping("/default/{projectNo}")
    public ModelAndView endProject(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = shippingService.findProjectListByProjectNo(projectNo);
        List<RewardShippingStatusDTO> rewardNotShippingList = shippingService.findRewardNotShippingListByProjectNo(projectNo);
        List<RewardShippingStatusDTO> rewardCompleteShippingList = shippingService.findRewardCompleteShippingListByProjectNo(projectNo);
        List<RewardShippingStatusDTO> rewardDelayShippingList = shippingService.findRewardDelayShippingListByProjectNo(projectNo);

        mv.addObject("project", project);
        mv.addObject("rewardNotShipping", rewardNotShippingList);
        mv.addObject("rewardCompleteShipping", rewardCompleteShippingList);
        mv.addObject("rewardDelayShipping", rewardDelayShippingList);
        mv.setViewName("/shipping/list");

        return mv;
    }

    /**
     * notShippedReward : 미발송 리워드에 대한 정보를 조회합니다.
     * @param projectNo : 프로젝트 번호를 담는 객체
     * @return mv : 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 조남기
     */
    @GetMapping("/notshipped/{projectNo}")
    public ModelAndView notShippedReward(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = shippingService.findNotProjectListByProjectNo(projectNo);
        List<FundingInfoDTO> funding = shippingService.findFundingInfoByProjectNo(projectNo);

        mv.addObject("project", project);
        mv.addObject("funding", funding);
        mv.setViewName("/shipping/notlist");

        return mv;
    }

    /**
     * completeShippedReward : 발송완료 리워드에 대한 정보를 조회합니다.
     * @param projectNo : 프로젝트 번호를 담는 객체
     * @return mv : 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 조남기
     */
    @GetMapping("/completeshipped/{projectNo}")
    public ModelAndView completeShippedReward(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = shippingService.findCompleteProjectListByProjectNo(projectNo);
        List<FundingInfoDTO> funding = shippingService.findCompleteFundingInfoByProjectNo(projectNo);

        mv.addObject("project", project);
        mv.addObject("funding", funding);
        mv.setViewName("/shipping/completelist");

        return mv;
    }

    /**
     * delayShippedReward : 발송완료 리워드에 대한 정보를 조회합니다.
     * @param projectNo : 프로젝트 번호를 담는 객체
     * @return mv : 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 조남기
     */
    @GetMapping("/delayshipped/{projectNo}")
    public ModelAndView delayShippedReward(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = shippingService.findDelayProjectListByProjectNo(projectNo);
        List<FundingInfoDTO> funding = shippingService.findDelayFundingInfoByProjectNo(projectNo);

        mv.addObject("project", project);
        mv.addObject("funding", funding);
        mv.setViewName("/shipping/delaylist");

        return mv;
    }

}
