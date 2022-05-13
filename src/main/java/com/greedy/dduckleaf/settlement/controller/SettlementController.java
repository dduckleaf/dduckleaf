package com.greedy.dduckleaf.settlement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.dduckleaf.settlement.check.dto.SettlementInfoPackage;
import com.greedy.dduckleaf.settlement.calculate.service.SettlementCalculateService;
import com.greedy.dduckleaf.settlement.check.service.SettlementCheckService;
import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import com.greedy.dduckleaf.settlement.service.SettlementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
 * 2022-05-09 (장민주) farmerSettlementOverviewPage -> findFarmerSettlementOverview 메소드 명 변경 및 코드 수정
 * 2022-05-10 (장민주) modifyFarmerCheckStatus 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.3
 */
@Controller
@RequestMapping("/settlement")
public class SettlementController {

    @Autowired
    private final SettlementService mainService;
    @Autowired
    private final SettlementCalculateService calculateService;
    @Autowired
    private final SettlementCheckService checkService;
    private final ObjectMapper mapper;
    private final ModelMapper modelMapper;

    public SettlementController(SettlementService mainService, SettlementCalculateService calculateService, SettlementCheckService checkService, ObjectMapper mapper, ModelMapper modelMapper) {
        this.mainService = mainService;
        this.calculateService = calculateService;
        this.checkService = checkService;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }

    /**
     * findFarmerSettlementOverview: 파머페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트번호
     * @return mv: 프로젝트정보, 정산금관리 화면 경로
     * @author 장민주
     */
    @GetMapping("/farmer/overview/{projectNo}")
    public ModelAndView findFarmerSettlementOverview(ModelAndView mv, @PathVariable int projectNo) {

        com.greedy.dduckleaf.settlement.calculate.dto.SettlementInfoPackage settlementInfoPackage =
                calculateService.findSettlementInfoPackage(projectNo);

        mv.addObject("project", settlementInfoPackage.getSettlementInfo().getProject());
        mv.addObject("settlementInfo", settlementInfoPackage.getSettlementInfo());
        mv.addObject("feeInfo", settlementInfoPackage.getFeeInfo());
        mv.addObject("settlementPaymentInfos", settlementInfoPackage.getSettlementPaymentInfos());
        mv.setViewName("settlement/farmer/overview");

        System.out.println("project = " + settlementInfoPackage.getSettlementInfo().getProject());
        System.out.println("settlementInfoPackage = " + settlementInfoPackage);

        return mv;
    }

    /**
     * projectManageOverviewPage: 프로젝트관리페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트번호
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
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트번호
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

    /**
     * calculatePage: 정산정보가 계산된 테이블 조회를 요청하는 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트번호
     * @return 메뉴바에 출력될 프로젝트 정보, 정산정보 계산 테이블 화면 경로
     * @author 장민주
     */
    @GetMapping("/calculate/table/{projectNo}")
    public ModelAndView calculatePage(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = mainService.findProjectDetail(projectNo);

        mv.addObject("project", project);
        mv.setViewName("settlement/projectmanager/calculate");

        return mv;
    }

    /**
     * calculateSettlementPayment: 회차별 정산금 지급내역 계산 및 지급내역조회를 요청하는 메소드입니다.
     * @param projectNo 프로젝트번호
     * @return 기본정산정보, 회차별 정산금 지급내역목록, 적용수수료정보
     * @author 장민주
     */
    @GetMapping(value = "/calculate/{projectNo}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String calculateSettlementPayment(@PathVariable int projectNo) throws JsonProcessingException {

        com.greedy.dduckleaf.settlement.calculate.dto.SettlementInfoPackage settlementInfoPackage =
                calculateService.findSettlementInfoPackage(projectNo);

        return mapper.writeValueAsString(settlementInfoPackage);
    }

    /**
     * modifyFarmerCheckStatus: 파머가 정산정보를 확인했음을 데이터베이스에 반영할 것을 요청하는 메소드입니다.
     * @param paymentNo 파머가 확인한 정산금지급내역 번호
     * @return 데이터 수정 성공실패 여부
     * @author 장민주
     */
    @PostMapping(value = "/check", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String modifyFarmerCheckStatus(@RequestBody int paymentNo) throws JsonProcessingException {

        /* 확인 요청이 접수되었다는 메시지 또는 접수가 실패되었다는 메시지를 전달 */
        String modifyResult = checkService.modifySettlementPaymentInfo(paymentNo);

        return  mapper.writeValueAsString(modifyResult);
    }

    /**
     * paymentSettingPage: 회차별 정산금 지급일 등록 페이지로 이동을 요청하는 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트번호
     * @return 기본정산정보, 회차별 정산금 지급내역목록, 적용수수료정보
     * @author 장민주
     */
    @GetMapping("/paymentSetting/{projectNo}")
    public ModelAndView paymentSettingPage(ModelAndView mv, @PathVariable int projectNo) {

        com.greedy.dduckleaf.settlement.check.dto.SettlementInfoPackage settlementInfoPackage =
                modelMapper.map(calculateService.findSettlementInfoPackage(projectNo),
                        com.greedy.dduckleaf.settlement.check.dto.SettlementInfoPackage.class);

        mv.addObject("settlementInfoPackage", settlementInfoPackage);
        mv.addObject("project", settlementInfoPackage.getSettlementInfo().getProject());
        mv.setViewName("settlement/projectmanager/paymentSetting");


        return mv;
    }

}
