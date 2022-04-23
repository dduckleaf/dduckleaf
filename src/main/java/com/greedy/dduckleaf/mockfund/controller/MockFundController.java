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

    @PostMapping("/modify")
    public String modifyMockFundBasicInfo(RedirectAttributes rttr, MockFundInfoDTO mockFundInfo) {

        mockFundService.modifyBasicInfo(mockFundInfo);

        rttr.addFlashAttribute("modifySeccessMessage", "기본정보 수정 성공");

        return "redirect:mockfund/mockfundmain";
    }

}
