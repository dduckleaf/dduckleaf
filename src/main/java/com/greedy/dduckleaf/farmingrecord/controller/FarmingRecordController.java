package com.greedy.dduckleaf.farmingrecord.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.farmingrecord.dto.FarmingRecordDTO;
import com.greedy.dduckleaf.farmingrecord.service.FarmingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : FarmingRecordController
 * Comment : 농사일지
 * History
 * 2022-05-06 (차화응) 처음 작성
 * 2022-05-07 (차화응) 농사일지 목록조회 메소드 작성
 * 2022-05-08 (차화응) 농사일지 상세조회 메소드 작성
 * 2022-05-09 (차화응) 농사일지 작성하기 메소드 작성 / 농사일지 수정하기 메소드 작성
 * 2022-05-10 (차화응) 농사일지 삭제하기 메소드 작성
 *
 * </pre>
 * @version 1.0.5
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
    public ModelAndView findFarmingRecordList(ModelAndView mv, @PageableDefault(size = 10) Pageable pageable) {

        Page<FarmingRecordDTO> farmingRecordList = farmingRecordService.findFarmingRecordList(pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(farmingRecordList);

        mv.addObject("farmingRecordList", farmingRecordList);
        mv.addObject("paging", paging);
        mv.setViewName("farmingrecord/list");
        return mv;
    }

    /**
     * findFarmingRecordDetail : 농사일지 상세정보를 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param farmingRecordNo : 조회할 농사일지 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/detail/{farmingRecordNo}")
    public ModelAndView findFarmingRecordDetail(ModelAndView mv, @PathVariable int farmingRecordNo) {

        FarmingRecordDTO farmingRecord = farmingRecordService.findFarmingRecordDetail(farmingRecordNo);

        farmingRecordService.updateFarmingRecordCount(farmingRecordNo);

        mv.addObject("farmingRecord", farmingRecord);
        mv.setViewName("farmingrecord/detail");

        return mv;
    }

    /**
     * registPage : 농사일지를 작성하기 위해 작성 폼으로 이동합니다.
     * @param mv : 요청 경로를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/regist")
    public ModelAndView registPage(ModelAndView mv) {

        mv.setViewName("farmingrecord/regist");

        return mv;
    }

    /**
     * registFarmingRecord : 농사일지를 등록합니다.
     * @param user : 회원 정보를 담는 객체
     * @param mv : 요청 경로를 담는 객체
     * @param newFarmingRecord : 등록할 농사일지 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @PostMapping("/regist")
    public ModelAndView registFarmingRecord(@AuthenticationPrincipal CustomUser user, ModelAndView mv, FarmingRecordDTO newFarmingRecord) {

        int memberNo = user.getMemberNo();
        newFarmingRecord.setFarmerNo(memberNo);
        newFarmingRecord.setFarmingRecordStatus("Y");
        newFarmingRecord.setPublicStatus("N");
        newFarmingRecord.setProjectNo(1);
        farmingRecordService.registNewFarmingRecord(newFarmingRecord);

        mv.setViewName("redirect:/farmingrecord/list");

        return mv;
    }

    /**
     * modifyPage : 농사일지를 수정하기 위해 작성 폼으로 이동합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param farmingRecordNo : 수정할 농사일지 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/modify/{farmingRecordNo}")
    public ModelAndView modifyPage(ModelAndView mv, @PathVariable int farmingRecordNo) {

        FarmingRecordDTO farmingRecordDetail = farmingRecordService.findFarmingRecordDetail(farmingRecordNo);

        mv.addObject("farmingRecordDetail", farmingRecordDetail);
        mv.setViewName("farmingrecord/modify");

        return mv;
    }

    /**
     * modifyFarmingRecord : 농사일지를 수정합니다.
     * @param updateFarmingRecord : 수정할 농사일지 정보를 담는 객체
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @PostMapping("/modify")
    public ModelAndView modifyFarmingRecord(ModelAndView mv, FarmingRecordDTO updateFarmingRecord) {

        farmingRecordService.modifyFarmingRecord(updateFarmingRecord);

        mv.setViewName("redirect:/farmingrecord/list");

        return mv;
    }

    /**
     * removeFarmingRecord : 농사일지를 삭제합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param farmingRecordNo : 삭제할 농사일지 번호
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/remove/{farmingRecordNo}")
    public ModelAndView removeFarmingRecord(ModelAndView mv, @PathVariable int farmingRecordNo) {

        farmingRecordService.removeFarmingRecord(farmingRecordNo);

        mv.setViewName("redirect:/farmingrecord/list");

        return mv;
    }

}
