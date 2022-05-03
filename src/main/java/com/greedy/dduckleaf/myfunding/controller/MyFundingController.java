package com.greedy.dduckleaf.myfunding.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.myfunding.dto.MyFundingDTO;
import com.greedy.dduckleaf.myfunding.service.MyFundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class: MyFundingController
 * Comment : 마이펀딩
 * History
 * 2022/04/27 (박상범) 처음 작성 / 마이 펀딩 페이지로 이동 관련 메소드 작성 시작
 * 2022/04/28 (박상범) 마이 펀딩 페이지로 이동 관련 메소드 작성 완료
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Controller
@RequestMapping("/myfunding")
public class MyFundingController {

    private final MyFundingService myFundingService;

    @Autowired
    public MyFundingController(MyFundingService myFundingService) {
        this.myFundingService = myFundingService;
    }

    /**
     * myfundingDefaultPage: 회원 번호를 통해 회원의 펀딩 횟수, 모의펀딩 횟수, 티켓 갯수를 조회하는 페이지로 포워딩합니다.
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping("/default")

    public ModelAndView myfundingDefaultPage(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        MyFundingDTO myFunding = myFundingService.findMyFundingByMemberNo(memberNo);

        mv.addObject("myFunding", myFunding);
        mv.setViewName("/myfunding/default");

        return mv;
    }
}
