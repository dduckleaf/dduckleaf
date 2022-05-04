package com.greedy.dduckleaf.mockfund.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundRewardDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
import com.greedy.dduckleaf.mockfund.service.MockFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * <pre>
 * Class : MockFundController
 * Comment : 모의펀딩 신청
 * History
 * 2022/04/20 (조남기) 모의펀딩 기본 정보 조회 관련 메소드 구현 시작
 * 2022/04/21 (조남기) 모의펀딩 기본 정보, 스토리, 리워드 정보 조회 관련 메소드 구현 완료, 기본 정보 업데이트 관련 메소드 구현 시작
 * 2022/04/22 (조남기) 모의펀딩 기본 정보 컬럼 1개 업데이트 완료
 * 2022/04/23 (조남기) 모의펀딩 기본 정보 이미지 제외 업데이트 완료
 * 2022/04/24 (조남기) 모의펀딩 기본 정보 업데이트 모달 추가 작업
 * 2022/04/25 (조남기) 모의펀딩 스토리 업데이트 완료, 리워드 정보 업데이트 메소드 구현 시작
 * 2022/04/26 (조남기) 모의펀딩 리워드 정보 업데이트 완료
 * </pre>
 * @version 1.0.6
 * @author 조남기
 */
@Controller
@RequestMapping("/mockfund")
public class MockFundController {

    private final MockFundService mockFundService;

    @Autowired
    public MockFundController(MockFundService mockFundService) {
        this.mockFundService = mockFundService;
    }

    @GetMapping("/mockfundmain")
    public ModelAndView mockFundMainPage(ModelAndView mv) {

        mv.setViewName("/mockfund/mockfundmain");

        return mv;
    }

    public int findMockFundNoByFarmerNo(@AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        int mockFundNo = mockFundService.findMockFundNoByFarmerId(farmerNo);

        return mockFundNo;
    }

    @GetMapping("/basicinfo")
    public ModelAndView findMockFundInfoByCode(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int mockFundNo = findMockFundNoByFarmerNo(user);

        MockFundInfoDTO info = mockFundService.findMockFundInfoByMockFundNo(mockFundNo);
        List<RewardCategoryDTO> categoryList = mockFundService.findRewardCategoryList();
        List<MockFundDTO> mockFundList = mockFundService.findMockFundList();

        mv.addObject("info", info);
        mv.addObject("categoryList", categoryList);
        mv.addObject("mockFundList", mockFundList);
        mv.setViewName("/mockfund/regist/basicinfo");

        return mv;
    }

    @GetMapping("/story")
    public ModelAndView findStoryInfoByCode(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int mockFundNo = findMockFundNoByFarmerNo(user);

        MockFundInfoDTO info = mockFundService.findStoryInfoByMockFundNo(mockFundNo);

        mv.addObject("info", info);
        mv.setViewName("/mockfund/regist/story");

        return mv;
    }

    @GetMapping("/reward")
    public ModelAndView findRewardByCode(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int mockFundNo = findMockFundNoByFarmerNo(user);

        MockFundRewardDTO reward = mockFundService.findRewardByMockFundNo(mockFundNo);

        mv.addObject("reward", reward);
        mv.setViewName("/mockfund/regist/reward");

        return mv;
    }

    @GetMapping("/{mockFundCode}")
    public ModelAndView findMockFundStatus(ModelAndView mv, @PathVariable int mockFundCode) {

        MockFundDTO mockFund = mockFundService.findMockFundByCode(mockFundCode);

        mv.addObject("mockFund", mockFund);
        mv.setViewName("/mockfund/mockfundmain");

        return mv;
    }

    @GetMapping("/modify/basicinfo")
    public void modifyMockFundInfo() {}

    @PostMapping("/modify/basicinfo")
    public ModelAndView modifyMockFundBasicInfo(ModelAndView mv, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyBasicInfo(mockFundInfo);

        mv.setViewName("redirect:/mockfund/mockfundmain");

        return mv;
    }

    @GetMapping("/agreement")
    public void modifyAgreement() {}

    @PostMapping("/agreement")
    public ModelAndView modifyMockFundAgreementStatus(ModelAndView mv, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyAgreementStatus(mockFundInfo);

        mv.setViewName("redirect:/mockfund/story");

        return mv;
    }

    @GetMapping("/modify/story")
    public void modifyStory() {}

    @PostMapping("/modify/story")
    public ModelAndView modifyMockFundStory(ModelAndView mv, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyStory(mockFundInfo);

        mv.setViewName("redirect:/mockfund/mockfundmain");

        return mv;
    }

    @GetMapping("/modify/reward")
    public void modifyReward() {}

    @PostMapping("/modify/reward")
    public ModelAndView modifyMockFundReward(ModelAndView mv, MockFundRewardDTO mockFundReward) {

        mockFundService.modifyReward(mockFundReward);

        mv.setViewName("redirect:/mockfund/mockfundmain");

        return mv;
    }

}
