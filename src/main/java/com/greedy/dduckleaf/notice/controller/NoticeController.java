package com.greedy.dduckleaf.notice.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) { this.noticeService = noticeService; }

    @GetMapping("/list")
    public ModelAndView findNoticeList(ModelAndView mv, @PageableDefault Pageable pageable) {

        System.out.println("pageable = " + pageable);

        Page<NoticeDTO> noticeList = noticeService.findNoticeList(pageable);

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
    public void registNotice() {}

    @PostMapping("/regist")
    public ModelAndView registNotice(ModelAndView mv, NoticeDTO newNotice, RedirectAttributes rttr) {

        noticeService.registNewNotice(newNotice);


    }
}
