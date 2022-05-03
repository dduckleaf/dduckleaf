package com.greedy.dduckleaf.platformqa.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.notice.dto.NoticeCategoryDTO;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaCategoryDTO;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaDTO;
import com.greedy.dduckleaf.platformqa.service.PlatformQaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : PlatformQaController
 * Comment : 1:1문의
 * History
 * 2022-04-30 (차화응) 처음 작성 / 1:1문의 목록조회 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
@Controller
@RequestMapping("/qna")
public class PlatformQaController {

    private final PlatformQaService platformQaService;

    @Autowired
    public PlatformQaController(PlatformQaService platformQaService) {
        this.platformQaService = platformQaService;
    }

    /**
     * findPlatformQaList : 1:1문의 목록을 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param pageable : 페이징 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/list")
    public ModelAndView findPlatformQaList(ModelAndView mv, @PageableDefault(size = 5) Pageable pageable) {

        Page<PlatformQaDTO> platformQaList = platformQaService.findPlatformQaList(pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(platformQaList);
        List<PlatformQaCategoryDTO> platformQaCategoryList = platformQaService.findAllPlatformQaCategory();

        mv.addObject("platformQaList", platformQaList);
        mv.addObject("paging", paging);
        mv.addObject("platformQaCategoryList", platformQaCategoryList);
        mv.setViewName("platformqa/list");

        return mv;
    }

    @GetMapping("/regist")
    public String registPage() {
        return "platformqa/regist";
    }

}