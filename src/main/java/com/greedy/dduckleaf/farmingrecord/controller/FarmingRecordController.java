package com.greedy.dduckleaf.farmingrecord.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.farmingrecord.dto.FarmingRecordDTO;
import com.greedy.dduckleaf.farmingrecord.service.FarmingRecordService;
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
 * Class : FarmingRecordController
 * Comment : 농사일지
 * History
 * 2022-05-06 (차화응) / 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
@Controller
@RequestMapping("/farmingrecord")
public class FarmingRecordController {

    private final FarmingRecordService farmingRecordService;

    @Autowired
    public FarmingRecordController(FarmingRecordService farmingRecordService) {
        this.farmingRecordService = farmingRecordService;
    }

    /**
     * findFarmingRecordList : 농사일지 목록을 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param pageable : 페이징 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/list")
    public ModelAndView findFarmingRecordList(ModelAndView mv, @PageableDefault(size = 5) Pageable pageable) {

        Page<FarmingRecordDTO> farmingRecordList = farmingRecordService.findFarmingRecordList(pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(farmingRecordList);

        mv.addObject("farmingRecordList", farmingRecordList);
        mv.addObject("paging", paging);
        mv.setViewName("farmingrecord/list");
        return mv;
    }

}
