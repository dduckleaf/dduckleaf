package com.greedy.dduckleaf.settlement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * farmerSettlementOverviewPage: 파머페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @author 장민주
     */
    @GetMapping("/farmer/overview")
    public void farmerSettlementOverviewPage() {}

    /**
     * projectManageOverviewPage: 프로젝트관리페이지 화면 경로를 찾아가기 위한 메소드입니다.
     * @author 장민주
     */
    @GetMapping("/projectmanager/overview")
    public void projectManageOverviewPage() {}
}
