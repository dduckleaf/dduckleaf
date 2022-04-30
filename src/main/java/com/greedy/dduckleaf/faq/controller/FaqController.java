package com.greedy.dduckleaf.faq.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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


    private final FaqService service;

    @Autowired
    public FaqController(FaqService service) {
        this.service = service;
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
        Page<FaqDTO> faqList = service.findFaqList(pageable);
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

        FaqDTO faq = service.findFaqDetail(faqNo);


        mv.addObject("faq", faq);
        mv.setViewName("faq/detail");

        return mv;
    }

}
