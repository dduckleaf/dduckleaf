package com.greedy.dduckleaf.settlement.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import com.greedy.dduckleaf.settlement.entity.SettlementInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class SettlementInfoRepositoryTests {

    @Autowired
    private SettlementInfoRepository repository;

    @Test
    public void initTest() {
        assertNotNull(repository);
    }

    @Test
    @DisplayName("프로젝트 번호로 해당 프로젝트의 정산정보 조회")
    public void findByProject_ProjectNo_test() {

        //given
        int projectNo = 1;
        
        //when
        SettlementInfo settlementInfo = repository.findByProject_ProjectNo(projectNo);
        
        //then
        assertNotNull(settlementInfo);
        System.out.println("settlementInfo = " + settlementInfo);
    }
}
