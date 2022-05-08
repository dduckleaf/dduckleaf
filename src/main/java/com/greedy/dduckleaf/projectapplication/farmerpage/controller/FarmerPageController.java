package com.greedy.dduckleaf.projectapplication.farmerpage.controller;

import com.greedy.dduckleaf.projectapplication.dto.RefundPolicyDTO;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.farmerpage.service.FarmerPageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class: FarmerPageController
 * Comment : 파머 페이지에서 리워드 정보와 반환정책을 조회하는 컨트롤러 클래스 입니다.
 * History
 * 2022/05/08 (박휘림) 처음 작성 /
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
@Controller
@RequestMapping("/farmerpage")
public class FarmerPageController {

    private final FarmerPageService farmerPageService;

    @Autowired
    public FarmerPageController(FarmerPageService farmerPageService) {
        this.farmerPageService = farmerPageService;
    }

    /**
     * findRefundPolicy: 파머페이지에서 반환 정책을 조회하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return : 반환 정책 정보
     * @author 박휘림
     */
    @GetMapping("/policy/{projectNo}")
    public ModelAndView findRefundPolicy(ModelAndView mv, @PathVariable int projectNo) {

        RefundPolicyDTO refundPolicy = farmerPageService.findRefundPolicy(projectNo);

        mv.addObject("refundPolicy", refundPolicy);

        return mv;
    }

    /**
     * findRefundPolicy: 파머페이지에서 리워드 정보를 조회하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return : 리워드 정보
     * @author 박휘림
     */
    @GetMapping("/reward/{projectNo}")
    public ModelAndView findRewardInfo(ModelAndView mv, @PathVariable int projectNo) {

        RewardRegistInfoDTO rewardInfo = farmerPageService.findRewardInfo(projectNo);

        mv.addObject("rewardInfo", rewardInfo);

        return mv;
    }

}
