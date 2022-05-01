package com.greedy.dduckleaf.settlement.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import com.greedy.dduckleaf.settlement.dto.SettlementInfoDTO;
import com.greedy.dduckleaf.settlement.dto.SettlementOverview;
import com.greedy.dduckleaf.settlement.dto.SettlementPaymentInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.util.List;

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

    @Test
    @DisplayName("파머의 정산정보 조회 요청 테스트")
    @Transactional
    public void findSettlementPaymentInfo_test() {
        //given
        int projectNo = 1;

        //when
        SettlementOverview settlementOverview = service.findSettlementPaymentInfo(projectNo);

        //then
        assertNotNull(settlementOverview);
        assertNotNull(settlementOverview.getSettlementInfo());
        assertNotNull(settlementOverview.getSettlementPaymentInfos());

//        assertEquals(settlementOverview.getSettlementInfo().getClass(), SettlementInfoDTO.class);
//        settlementOverview.getSettlementPaymentInfos().forEach(settlementPaymentInfo -> {
//            assertEquals(settlementPaymentInfo.getClass(), SettlementPaymentInfoDTO.class);
//        });

        System.out.println("settlementOverview = " + settlementOverview);
    }
    
    @Test
    public void findSettlementInfoForEndProject_test() {
        //given
        int projectNo = 1;
        
        //when
        SettlementInfoDTO settlementInfoDTO = service.findSettlementInfoForEndProject(projectNo);
        
        //then
        assertNotNull(settlementInfoDTO);
        System.out.println("settlementInfoDTO = " + settlementInfoDTO);
        
    }

}
