package com.greedy.dduckleaf.settlement.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementServiceTests {

    @Autowired
    private SettlementService service;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(service);
        assertNotNull(modelMapper);
    }

//    @Test
//    @DisplayName("내부연산: 파머의 정산정보 조회 요청 테스트")
//    @Transactional
//    public void findSettlementPaymentInfo_test() {
//        //given
//        int projectNo = 1;
//
//        //when
//        SettlementOverview settlementOverview = service.findSettlementPaymentInfo(projectNo);
//
//        //then
//        assertNotNull(settlementOverview);
//        assertNotNull(settlementOverview.getSettlementInfo());
//        assertNotNull(settlementOverview.getSettlementPaymentInfos());
//
////        assertEquals(settlementOverview.getSettlementInfo().getClass(), SettlementInfoDTO.class);
////        settlementOverview.getSettlementPaymentInfos().forEach(settlementPaymentInfo -> {
////            assertEquals(settlementPaymentInfo.getClass(), SettlementPaymentInfoDTO.class);
////        });
//
//        System.out.println("settlementOverview = " + settlementOverview);
//    }

//    @Test
//    @DisplayName("내부연산: 프로젝트의 정산정보 조회 테스트")
//    public void findSettlementInfoForEndProject_test() {
//        //given
//        int projectNo = 1;
//
//        //when
//        SettlementInfoDTO settlementInfoDTO = service.findSettlementInfoForEndProject(projectNo);
//
//        //then
//        assertNotNull(settlementInfoDTO);
//        System.out.println("settlementInfoDTO = " + settlementInfoDTO);
//
//    }

    @Test
    @DisplayName("달성률이 100% 이상인 종료된 프로젝트 목록 조회 테스트")
    public void findAllEndProjectsAchievedSuccess_test() {

        //given
        int progerssStatus = 4;
        int achievementRate = 100;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("projectNo").descending());

        //when
        Page<ProjectDTO> projects = service.findAllEndProjectsAchievedSuccess(progerssStatus, achievementRate, pageable);

        //then
        assertNotNull(projects);
        projects.forEach(project -> {
            assertEquals(project.getClass(), ProjectDTO.class);
        });
        projects.forEach(System.out::println);
    }

    @Test
    @DisplayName("프로젝트 번호로 프로젝트 상세 조회 테스트")
    public void findProjectDetail_test() {

        //given
        int projectNo = 1;

        //when
        ProjectDTO projectDetail = service.findProjectDetail(projectNo);

        //then
        assertNotNull(projectDetail);
        assertEquals(projectDetail.getClass(), ProjectDTO.class);
    }

}
