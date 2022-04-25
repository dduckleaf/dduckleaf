package com.greedy.dduckleaf.mockfund.controller;

import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundRewardDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
import com.greedy.dduckleaf.mockfund.service.MockFundService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * </pre>
 * @version 1.0.3
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

    @GetMapping("/basicinfo/{infoCode}")
    public ModelAndView findMockFundInfoByCode(ModelAndView mv, @PathVariable int infoCode) {

        MockFundInfoDTO info = mockFundService.findMockFundInfoByCode(infoCode);
        List<RewardCategoryDTO> categoryList = mockFundService.findRewardCategoryList();

        mv.addObject("info", info);
        mv.addObject("categoryList", categoryList);
        mv.setViewName("/mockfund/regist/basicinfo");

        return mv;
    }

    @GetMapping("/story/{infoCode}")
    public ModelAndView findStoryInfoByCode(ModelAndView mv, @PathVariable int infoCode) {

        MockFundInfoDTO info = mockFundService.findStoryInfoByCode(infoCode);

        mv.addObject("info", info);
        mv.setViewName("/mockfund/regist/story");

        return mv;
    }

    @GetMapping("/reward/{infoCode}")
    public ModelAndView findRewardByCode(ModelAndView mv, @PathVariable int infoCode) {

        MockFundRewardDTO info = mockFundService.findRewardByCode(infoCode);

        mv.addObject("info", info);
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
    public String modifyMockFundBasicInfo(RedirectAttributes rttr, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyBasicInfo(mockFundInfo);

        rttr.addFlashAttribute("modifySuccessMessage", "기본정보 수정 성공");

        return "redirect:/mockfund/" + mockFundInfo.getMockFundInfoNo();
    }

    @GetMapping("/agreement")
    public void modifyAgreement() {}

    @PostMapping("/agreement")
    public String modifyMockFundAgreementStatus(RedirectAttributes rttr) {
        System.out.println("=============");
        /* session에 있는 memberNo 받아와서 넘겨줘야함 */
        int memberNo = 3;
        int infoNo = mockFundService.modifyAgreementStatus(memberNo);

        rttr.addFlashAttribute("modifySuccessMessage", "동의 성공");

        return "redirect:/mockfund/story/" + infoNo;
    }

    @GetMapping("/modify/story")
    public void modifyStory() {}

    @PostMapping("/modify/story")
    public String modifyMockFundStory(RedirectAttributes rttr, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyStory(mockFundInfo);

        rttr.addFlashAttribute("modifySuccessMessage", "기본정보 수정 성공");

        return "redirect:/mockfund/" + mockFundInfo.getMockFundInfoNo();
    }

}
