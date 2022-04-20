package com.greedy.dduckleaf.notice.controller;

import com.greedy.common.paging.Pagenation;
import com.greedy.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        Page<NoticeDTO> noticeList = noticeService.findNoticeList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(noticeList);

        mv.addObject("noticeList", noticeList);
        mv.addObject("paging", paging);
        mv.setViewName("notice/list");

        return mv;
    }

//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam(value = "keyword") String keyword, ModelAndView mv) {
//        List<NoticeDTO> noticeDTOList = noticeService.searchPosts(keyword);
//        mv.addObject("noticeList", noticeDTOList);
//        mv.setViewName("notice/list");
//
//        return mv;
//    }
}
