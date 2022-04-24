package com.greedy.dduckleaf.notice.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.notice.dto.NoticeCategoryDTO;
import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.dto.NoticeForListDTO;
import com.greedy.dduckleaf.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) { this.noticeService = noticeService; }

    @GetMapping("/list")
    public ModelAndView findNoticeList(ModelAndView mv, @PageableDefault Pageable pageable) {

        System.out.println("pageable = " + pageable);

        Page<NoticeForListDTO> noticeList = noticeService.findNoticeList(pageable);
        noticeList.forEach(System.out::println);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(noticeList);

        mv.addObject("noticeList", noticeList);
        mv.addObject("paging", paging);
        mv.setViewName("notice/list");

        return mv;
    }

//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam(value = "keyword") String keyword, ModelAndView mv) {
//
//        List<NoticeDTO> noticeDTOList = noticeService.searchPosts(keyword);
//        mv.addObject("noticeList", noticeDTOList);
//        mv.setViewName("notice/list");
//
//        return mv;
//    }

    @GetMapping("/{noticeNo}")
    public ModelAndView findNoticeDetail(ModelAndView mv, @PathVariable int noticeNo) {

        NoticeDTO notice = noticeService.findNoticeDetail(noticeNo);

        mv.addObject("notice", notice);
        mv.setViewName("/notice/detail");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView registPage(ModelAndView mv) {

        List<NoticeCategoryDTO> categoryList = noticeService.findAllNoticeCategory();
        mv.addObject("categoryList", categoryList);
        mv.setViewName("/notice/regist");

        return mv;
    }

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<NoticeCategoryDTO> findNoticeCategoryList() {

        return noticeService.findAllNoticeCategory();
    }

    @PostMapping("/regist")
    public ModelAndView registNotice(@AuthenticationPrincipal CustomUser user, ModelAndView mv, NoticeDTO newNotice) {

        int memberNo = user.getMemberNo();

        newNotice.setAdminNo(memberNo);
        newNotice.setNoticeStatus("Y");
        noticeService.registNewNotice(newNotice);

        mv.setViewName("redirect:/notice/list");

        return mv;
    }

}
