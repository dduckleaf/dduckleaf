package com.greedy.dduckleaf.faq.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.dto.MemberDTO;
import com.greedy.dduckleaf.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * <pre>
 * Class: FaqController
 * Comment : FAQ 자주묻는 질문
 * History
 * 2022/04/27 (이용선) 처음 작성 / FAQ 목록 조회 메소드 작성 시작
 * 2022/04/28 (이용선) FAQ 상세조회 메소드 작성
 * </pre>
 * @version 1.0.1
 *
 * @author 이용선
 */

@Controller
@RequestMapping("/faq")
public class FaqController {


    private final FaqService faqService;

    @Autowired
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

//    http://localhost:8008/faq/list
//    @GetMapping("/list")
//    public void FaqPage() {}

    /**
     * findFaqList : FAQ 목록을 조회합니다.
     * @param mv : 요청 정보를 받는 객체입니다.
     * @param pageable : 페이징 정보를 받는 객체입니다.
     * @return mv : 브라우저로 전달할 데이터와 경로 정보를 받는 객체입니다.
     *
     * @author 이용선
     */

    @GetMapping("/list")
    public ModelAndView findFaqList(ModelAndView mv, @PageableDefault Pageable pageable){

        System.out.println("pageable= " + pageable);
        Page<FaqDTO> faqList = faqService.findFaqList(pageable);
        faqList.forEach(System.out::println);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(faqList);

        mv.addObject("faqList", faqList);
        mv.addObject("paging", paging);
        mv.setViewName("faq/list");

        return mv;
    }

    /**
     * findFaqDetailList : FAQ 상세목록을 조회합니다.
     * @param mv : 요청 정보를 담는 객체
     * @param faqNo : FAQ 번호를 전달받습니다.
     * @return mv : 브라우저로 전달할 데이터와 경로 정보를 반환합니다.

     * @author 이용선
     */
    @GetMapping("/detail/{faqNo}")
    public ModelAndView findFaqDetailList(ModelAndView mv, @PathVariable int faqNo){

        FaqDTO faq = faqService.findFaqDetail(faqNo);


        mv.addObject("faq", faq);
        mv.setViewName("faq/detail");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView faqRegist(ModelAndView mv){


        mv.setViewName("faq/regist");

        return mv;
    }

    @PostMapping("/regist")
    public ModelAndView faqRegist(@AuthenticationPrincipal CustomUser user, ModelAndView mv,FaqDTO faqWrite, RedirectAttributes rttr){

        int memberNo = user.getMemberNo();

        MemberDTO member = new MemberDTO();
        member.setMemberNo(memberNo);
        faqWrite.setFaqStatus("Y");
        faqWrite.setMember(member);
        faqService.faqnewRegist(faqWrite);

//        rttr.addFlashAttribute("registSuccessMessage", "자주묻는 질문이 등록되었습니다.");

        mv.setViewName("redirect:/faq/list");

        return mv;
    }

//    @GetMapping("")


}
