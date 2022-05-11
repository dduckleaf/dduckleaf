package com.greedy.dduckleaf.admin.controller;

import com.greedy.dduckleaf.admin.dto.DashBoardDTO;
import com.greedy.dduckleaf.admin.sevice.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class: AdminController
 * Comment : 관리자 전용 기능
 * History
 * 2022/05/10 (박상범) 처음 작성 / 관리자 페이지 대시보드 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * dashboardPage: 관리자 대시보드를 조회합니다.
     * @return mv: 월별 펀딩금, 성공 프로젝트 갯수, 실패 프로젝트 갯수, 회원 가입 횟수, 회원 탈퇴 횟수를 ModelAndView 객체에 담아 return합니다.
     * @author 박상범
     */
    @GetMapping("/dashboard")
    public ModelAndView dashboardPage(ModelAndView mv){

        DashBoardDTO dashBoard = adminService.findDashBoard();

        mv.addObject("totalFundingAmountList", dashBoard.getTotalFundingAmountList());
        mv.addObject("successProjectAmountList", dashBoard.getSuccessProjectAmountList());
        mv.addObject("failedProjectAmountList", dashBoard.getFailedProjectAmountList());
        mv.addObject("registMemberAmountList", dashBoard.getRegistMemberAmountList());
        mv.addObject("removeMemberAmountList", dashBoard.getRemoveMemberAmountList());
        mv.setViewName("/admin/dashboard");

        return mv;
    }
}
