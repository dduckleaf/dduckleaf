package com.greedy.dduckleaf.settlement.controller;

import com.greedy.dduckleaf.settlement.calculate.dto.SettlementInfoDTO;
import com.greedy.dduckleaf.settlement.calculate.service.SettlementCalculateService;
import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import com.greedy.dduckleaf.settlement.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : SettlementController
 * Comment : 프로젝트 정산 프로세스를 담당하는 컨트롤러 클래스입니다.
 *
 * History
 * 2022-04-30 (장민주) 처음 작성
 * 2022-05-01 (장민주) farmerSettlementOverviewPage 메소드 작성
 * 2022-05-06 (장민주) projectManageOverviewPage 메소드 작성
 *
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Controller
@RequestMapping("/settlement")
public class SettlementController {

    @Autowired
    private final SettlementService mainService;
    @Autowired
    private final SettlementCalculateService calculateService;

    public SettlementController(SettlementService mainService, SettlementCalculateService calculateService) {
        this.mainService = mainService;
        this.calculateService = calculateService;
    }

    /**
     * farmerSettlementOverviewPage: 파머페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @author 장민주
     */
    @GetMapping("/farmer/overview")
    public void farmerSettlementOverviewPage() {}

    /**
     * projectManageOverviewPage: 프로젝트관리페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return mv: 프로젝트정보, 정산금관리 화면 경로
     * @author 장민주
     */
    @GetMapping("/projectmanager/overview/{projectNo}")
    public ModelAndView projectManageOverviewPage(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = mainService.findProjectDetail(projectNo);

        mv.addObject("project", project);
        mv.setViewName("settlement/projectmanager/overview");

        return mv;
    }

    /**
     * settlementInfoPage: 정산정보 계산 및 조회페이지 경로를 찾아가기 위한 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트정보, 정산정보 계산 및 조회 화면 경로
     * @author 장민주
     */
    @GetMapping("/settlementInfo/{projectNo}")
    public ModelAndView settlementInfoPage(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = mainService.findProjectDetail(projectNo);

        mv.addObject("project", project);
        mv.setViewName("settlement/projectmanager/calculate");

        return mv;
    }

    @GetMapping("/calculate/{projectNo}")
    public ModelAndView calculateSettlement(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = mainService.findProjectDetail(projectNo);

        SettlementInfoDTO settlementInfo = calculateService.findSettlementInfo(projectNo);

        mv.addObject("project", project);
        mv.addObject("settlementInfo", settlementInfo);
        mv.setViewName("settlement/projectmanager/calculate");

        return mv;
    }
}
