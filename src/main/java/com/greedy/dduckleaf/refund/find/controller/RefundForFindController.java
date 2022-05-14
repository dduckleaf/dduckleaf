package com.greedy.dduckleaf.refund.find.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.refund.find.dto.ProjectForAdminListDTO;
import com.greedy.dduckleaf.refund.find.dto.ProjectForAdminRefundingListDTO;
import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.find.dto.RefundingForAdminListDTO;
import com.greedy.dduckleaf.refund.find.service.RefundingForFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : RefundForFindController
 * Comment : 환불 조회
 *
 * History
 * 2022-05-04 홍성원 클래스 생성
 * 2022-05-10 adminFindRefundList 메소드 작성 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Controller
@RequestMapping("/refund/find")
public class RefundForFindController {

    private final RefundingForFindService service;

    @Autowired
    public RefundForFindController(RefundingForFindService service) {
        this.service = service;
    }

    @GetMapping("/member/list")
    public ModelAndView refundListPage(@AuthenticationPrincipal CustomUser user, ModelAndView mv,
        @PageableDefault(size=10, sort="refundingInfoNo", direction = Sort.Direction.DESC) Pageable pageable) {

        int memberNo = user.getMemberNo();

        Page<RefundingDTO> refundings = service.findRefundingListForMember(memberNo, pageable);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(refundings);

        mv.addObject("refundings", refundings);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("fundingSize", refundings != null ?refundings.getTotalPages(): 0);
        mv.setViewName("/refund/find/member/refundlist");

        return mv;
    }

    @GetMapping("/member/detail/{refundNo}")
    public ModelAndView refundDetailPage(ModelAndView mv, @PathVariable int refundNo) {

        RefundingDTO refunding = service.findRefundingInfo(refundNo);
        mv.addObject("refunding", refunding);
        mv.setViewName("/refund/find/member/refunddetail");

        return mv;
    }

    @GetMapping("/list/farmer")
    public ModelAndView sendFarmerRefundList(ModelAndView mv ,@AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        List<RefundingDTO> refundings = service.findFarmerRefundingList(memberNo);

        mv.addObject("refundings", refundings);
        mv.setViewName("/refund/find/farmer/refundlist");

        return mv;
    }

    @GetMapping("/detail/farmer/{refundNo}")
    public ModelAndView refundDetailFarmerPage(ModelAndView mv, @PathVariable int refundNo) {

        RefundingDTO refunding = service.findRefundingInfo(refundNo);

        mv.addObject("refunding", refunding);
        mv.setViewName("/refund/find/farmer/refunddetail");
        return mv;
    }

    @GetMapping("/admin/list")
    public ModelAndView adminFindRefundList(ModelAndView mv,
    @PageableDefault(size=10, sort="projectNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ProjectForAdminListDTO> projects = service.findAdminProjectList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projects);

        mv.addObject("paging", paging);
        mv.addObject("projects", projects);
        mv.setViewName("/refund/find/admin/refundlist");

        return mv;
    }

    @GetMapping("/admin/projectlist/{projectNo}")
    public ModelAndView adminFindRefundListByProject(ModelAndView mv, @PathVariable int projectNo,
                                                     @PageableDefault(size=10, sort="projectNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<RefundingForAdminListDTO> refundings = service.findAdminRefundingListByProject(projectNo, pageable);



        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(refundings);

        mv.addObject("paging", paging);
        mv.addObject("refundings", refundings);
        mv.addObject("projectNo", projectNo);
        mv.setViewName("/refund/find/admin/refundlistbyproject");
        return mv;
    }

    @GetMapping("/admin/refundingdetail/{refundingNo}/{refundstatus}")
    public ModelAndView findAdminRefundingDetail(ModelAndView mv, @PathVariable int refundingNo, @PathVariable int refundstatus) {

        RefundingDTO refunding = service.findRefundingInfo(refundingNo);
        mv.addObject("refunding", refunding);
        mv.addObject("refundstatus", refundstatus);

        mv.setViewName("/refund/find/admin/refunddetail");

        return mv;
    }

    @GetMapping("/admin/refundlist")
    public String sendAdminRefundManage() {

        return "/refund/find/admin/refundselect";
    }

    @GetMapping("/admin/statuslist/{refundstatus}")
    public ModelAndView adminFindRefundListByStatus(ModelAndView mv, @PathVariable int refundstatus,
                                                     @PageableDefault(size=10, sort="refundingInfoNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<RefundingForAdminListDTO> refundings = service.findAdminRefundingListByStatus(refundstatus, pageable);
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(refundings);

        String title = "";
        switch(refundstatus) {
            case 1: title = "이의신청 목록"; break;
            case 2: title = "환불 승인 목록"; break;
            case 3: title = "환불 거절 목록"; break;
        }

        mv.addObject("title", title);
        mv.addObject("paging", paging);
        mv.addObject("refundings", refundings);
        mv.addObject("refundstatus", refundstatus);

        if(refundstatus <= 3) {
            mv.setViewName("/refund/find/admin/refundlistbystatus");
        } else {
            mv.setViewName("/refund/find/admin/projectlist/" +refundstatus);
        }

        return mv;
    }
}