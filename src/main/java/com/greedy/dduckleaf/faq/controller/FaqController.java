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

/**
 * <pre>
 * Class: FaqController
 * Comment : FAQ 자주묻는 질문
 * History
 * 2022/04/27 (이용선) 처음 작성 / FAQ 목록 조회 메소드 작성 시작
 * 2022/04/28 (이용선) FAQ 상세조회 메소드 작성
 * 2022/05/07 (이용선) FAQ 수정 메소드 작성
 * 2022/05/07 (이용선) FAQ 삭제 메소드 작성
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

    /**
     * findFaqList : FAQ(자주묻는질문) 목록을 조회합니다.
     * @param mv : 요청 정보를 받는 객체입니다.
     * @param pageable : 페이징 정보를 받는 객체입니다.
     * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
     *
     * @author 이용선
     */

    @GetMapping("/list")
    public ModelAndView findFaqList(ModelAndView mv, @PageableDefault Pageable pageable){

        Page<FaqDTO> faqList = faqService.findFaqList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(faqList);

        mv.addObject("faqList", faqList);
        mv.addObject("paging", paging);
        mv.setViewName("faq/list");

        return mv;
    }

    /**
     * findFaqDetailList : FAQ(자주묻는질문) 상세목록을 조회합니다.
     * @param mv : 요청 정보를 담는 객체입니다.
     * @param faqNo : FAQ 번호를 전달받습니다.
     * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.

     * @author 이용선
     */
    @GetMapping("/detail/{faqNo}")
    public ModelAndView findFaqDetailList(ModelAndView mv, @PathVariable int faqNo){

        FaqDTO faq = faqService.findFaqDetail(faqNo);


        mv.addObject("faq", faq);
        mv.setViewName("faq/detail");

        return mv;
    }

    /**
    * faqRegistPage : FAQ(자주묻는질문) 등록페이지로 포워딩합니다.
    * @param mv : 요청 정보를 담는 객체입니다.
    * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
    * @author 이용선
    */
    @GetMapping("/regist")
    public ModelAndView faqRegistPage(ModelAndView mv){

        mv.setViewName("faq/regist");

        return mv;
    }

    /**
    * faqRegist: FAQ(자주묻는질문)을 등록한 후 목록페이지로 포워딩합니다.
    * @param mv : 요청 정보를 담는 객체입니다.
    * @param user : 회원 정보를 담는 객체입니다.
    * @param faqWrite : 등록할 FAQ 정보를 담는 객체입니다.
    * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
    * @author 이용선
    */
    @PostMapping("/regist")
    public ModelAndView faqRegist(@AuthenticationPrincipal CustomUser user, ModelAndView mv,FaqDTO faqWrite, RedirectAttributes rttr){

        int memberNo = user.getMemberNo();

        MemberDTO member = new MemberDTO();
        member.setMemberNo(memberNo);
        faqWrite.setFaqStatus("Y");
        faqWrite.setMember(member);
        faqService.faqnewRegist(faqWrite);

        mv.setViewName("redirect:/faq/list");

        return mv;
    }

    /**
    * modifyPage : FAQ(자주묻는질문) 수정페이지로 포워딩합니다.
    * @param mv : 요청 정보를 담는 객체입니다.
    * @param faqNo : 수정할 FAQ 번호입니다.
    * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
    * @author 이용선
    */
    @GetMapping("/modify/{faqNo}")
    public ModelAndView modifyFaq(ModelAndView mv, @PathVariable int faqNo) {

        FaqDTO faqmodify = faqService.findFaqDetail(faqNo);

        mv.addObject("modify", faqmodify);
        mv.setViewName("/faq/modify");

        return mv;
    }

    /**
    * modifyFaq : FAQ(자주묻는질문)내용을 수정한 후 목록페이지로 포워딩합니다.
    * @param mv : 요청 정보를 담는 객체입니다.
    * @param updateFaq : 수정할 FAQ 정보를 담은 객체입니다.
    * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
    * @author 이용선
    */
    @PostMapping("/modify")
    public ModelAndView modifyFaq(ModelAndView mv, FaqDTO updateFaq ) {
        faqService.modifyFaq(updateFaq);

        mv.setViewName("redirect:/faq/list");

        return mv;
    }

    /**
    * removeFaq : FAQ(자주묻는질문)을 삭제한 후 목록페이지로 포워딩합니다.
    * @param mv : 요청 정보를 담는 객체입니다.
    * @param faqNo : 삭제할 FAQ 번호입니다.
    * @return mv : 브라우저로 전달할 데이터와 경로 정보를 담은 객체입니다.
    * @author 이용선
    */
    @GetMapping("/remove/{faqNo}")
    public ModelAndView removeFaq(ModelAndView mv, @PathVariable int faqNo) {

        faqService.removeFaq(faqNo);

        mv.setViewName("redirect:/faq/list");

        return mv;
    }
}
