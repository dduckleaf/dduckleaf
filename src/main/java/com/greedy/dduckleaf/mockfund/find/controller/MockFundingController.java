package com.greedy.dduckleaf.mockfund.find.controller;

import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.find.service.MockFundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : MockFundingController
 * Comment : 모의펀딩 신청
 * History
 * 2022/04/28 (조남기) 모의펀딩 목록 조회 구현 시작, 페이징 및 모의펀딩내역 관련 데이터 제외 구현 완료
 * </pre>
 * @version 1.0.0
 * @author 조남기
 */
@Controller
@RequestMapping("/mockfunding")
public class MockFundingController {

    private final MockFundingService mockFundingService;

    @Autowired
    public MockFundingController(MockFundingService mockFundingService) {
        this.mockFundingService = mockFundingService;
    }

    @GetMapping("/list")
    public ModelAndView findMockFundingList(ModelAndView mv) {

        List<MockFundDTO> mockFundList = mockFundingService.findByProgressStatus();

        mv.addObject("mockFundList", mockFundList);
        mv.setViewName("/mockfunding/list");

        return mv;
    }
}
