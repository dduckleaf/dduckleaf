package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.common.utility.DateFormatting;
import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.Project;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementInfoForSettlementCalculateRepositoryTests {

    @Autowired
    private SettlementInfoForSettlementCalculateRepository settlementInfoRepository;
    @Autowired
    private ProjectForSettlementCalculateRepository projectRepository;

    @Test
    public void initTest() {
        assertNotNull(settlementInfoRepository);
        assertNotNull(projectRepository);
    }

    @Test
    @DisplayName("정산정보 등록 성공 테스트")
    public void save_success_Test() {

        //givan
        Project project = projectRepository.findById(3);

        SettlementInfo settlementInfo = new SettlementInfo();
        settlementInfo.setProject(project);
        settlementInfo.setSettlementTotalAmount(10000);
        settlementInfo.setFundingTotalAmount(10000);
        settlementInfo.setDonateAmount(10000);
        settlementInfo.setTotalCommissionAmount(10000);
        settlementInfo.setCalculateDate(getDateAndTime());

        //when
        settlementInfoRepository.save(settlementInfo);

        //then
        assertDoesNotThrow(() -> settlementInfoRepository.save(settlementInfo));
    }
    
    @Test
    @DisplayName("프로젝트번호로 정산정보 조회 테스트")
    public void findByProject_ProjectNo_test() {
        
        //given
        int projectNo = 1;
        
        //when
        SettlementInfo settlementInfo = settlementInfoRepository.findByProject_ProjectNo(projectNo);
        
        //then
        assertNotNull(settlementInfo);
        System.out.println("settlementInfo = " + settlementInfo);
    }
}
