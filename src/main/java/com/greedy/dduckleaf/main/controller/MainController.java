package com.greedy.dduckleaf.main.controller;

import com.greedy.dduckleaf.main.dto.MainPageDTO;
import com.greedy.dduckleaf.main.service.MainService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

/**
 * <pre>
 * Class : MainController
 * Comment : 실시간 랭킹, 떡잎추천
 * History
 * 2022-05-06 (박상범) 처음 작성 / 떡잎 추천 조회 관련 메소드 작성성 실시간 랭킹 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Controller
public class MainController {

    private final MessageSource messageSource;
    private final MainService mainService;

    public MainController(MessageSource messageSource, MainService mainService) {
        this.messageSource = messageSource;
        this.mainService = mainService;
    }

    /**
     * main : 실시간 랭킹, 떡잎 추천을 조회할 수 있는 메인 페이지로 포워딩 합니다.
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박상범
     */
    @GetMapping(value = {"/", "/main"})
    public ModelAndView main(ModelAndView mv) throws ParseException {

        MainPageDTO mainPage = mainService.findMainPage();

        mv.addObject("dduckleafRecommendList", mainPage.getDduckleafRecommendList());
        mv.addObject("rankingList", mainPage.getRankingList());
        mv.setViewName("/main/mainPage");

        return mv;
    }

    /**
     * main : 실시간 랭킹, 떡잎 추천을 조회할 수 있는 메인 페이지로 포워딩 합니다.
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박상범
     */
    @PostMapping(value = "/")
    public ModelAndView redirectMain(ModelAndView mv){

        mv.setViewName("/main/mainPage");

        return mv;
    }

}
