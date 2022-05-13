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

/**
 * <pre>
 * Class : NoticeController
 * Comment : 공지사항
 * History
 * 2022/04/19 (차화응) 처음 작성 / 공지사항 목록조회 메소드 작성
 * 2022/04/21 (차화응) 공지사항 상세조회 메소드 작성
 * 2022/04/23 (차화응) 공지사항 작성하기 메소드 작성
 * 2022/04/25 (차화응) 공지사항 수정하기 메소드 작성
 * </pre>
 * @version 1.0.3
 * @author 차화응
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) { this.noticeService = noticeService; }

    /**
     * findNoticeList : 공지사항 목록을 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param pageable : 페이징 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/list")
    public ModelAndView findNoticeList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<NoticeForListDTO> noticeList = noticeService.findNoticeList(pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(noticeList);

        mv.addObject("noticeList", noticeList);
        mv.addObject("paging", paging);
        mv.setViewName("notice/list");

        return mv;
    }

    /**
     * findNoticeDetail : 공지사항 상세정보를 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param noticeNo : 조회할 공지사항 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/detail/{noticeNo}")
    public ModelAndView findNoticeDetail(ModelAndView mv, @PathVariable int noticeNo) {

        NoticeDTO notice = noticeService.findNoticeDetail(noticeNo);
        noticeService.updateNoticeCount(noticeNo);  //조회수 갱신

        mv.addObject("notice", notice);
        mv.setViewName("notice/detail");

        return mv;
    }

    /**
     * registPage : 공지사항을 작성하기 위해 작성 폼으로 이동합니다.
     * @param mv : 요청 경로를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/regist")
    public ModelAndView registPage(ModelAndView mv) {

        List<NoticeCategoryDTO> categoryList = noticeService.findAllNoticeCategory();

        mv.addObject("categoryList", categoryList);
        mv.setViewName("notice/regist");

        return mv;
    }

    /**
     * findNoticeCategoryList : 공지사항 분류 목록을 조회합니다.
     *
     * @author 차화응
     */
    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<NoticeCategoryDTO> findNoticeCategoryList() {

        return noticeService.findAllNoticeCategory();
    }

    /**
     * registNotice : 공지사항을 등록합니다.
     * @param user : 회원 정보를 담는 객체
     * @param mv : 요청 경로를 담는 객체
     * @param newNotice : 등록할 공지사항 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @PostMapping("/regist")
    public ModelAndView registNotice(@AuthenticationPrincipal CustomUser user, ModelAndView mv, NoticeDTO newNotice) {

        int memberNo = user.getMemberNo();

        newNotice.setAdminNo(memberNo);
        newNotice.setNoticeStatus("Y");
        noticeService.registNewNotice(newNotice);

        mv.setViewName("redirect:/notice/list");

        return mv;
    }

    /**
     * modifyPage : 공지사항을 수정하기 위해 작성 폼으로 이동합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param noticeNo : 수정할 공지사항 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/modify/{noticeNo}")
    public ModelAndView modifyPage(ModelAndView mv, @PathVariable int noticeNo) {

        NoticeDTO noticeDetail = noticeService.findNoticeDetail(noticeNo);
        List<NoticeCategoryDTO> categoryList = noticeService.findAllNoticeCategory();

        mv.addObject("noticeDetail", noticeDetail);
        mv.addObject("categoryList", categoryList);
        mv.setViewName("notice/modify");

        return mv;
    }

    /**
     * modifyNotice : 공지사항을 수정합니다.
     * @param updateNotice : 수정할 공지사항 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @PostMapping("/modify")
    public ModelAndView modifyNotice(ModelAndView mv, NoticeDTO updateNotice) {

        noticeService.modifyNotice(updateNotice);

        mv.setViewName("redirect:/notice/list");

        return mv;
    }

    /**
     * removeNotice : 공지사항을 삭제합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param noticeNo : 삭제할 공지사항 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/remove/{noticeNo}")
    public ModelAndView removeNotice(ModelAndView mv, @PathVariable int noticeNo) {

        noticeService.removeNotice(noticeNo);

        mv.setViewName("redirect:/notice/list");

        return mv;
    }

}
