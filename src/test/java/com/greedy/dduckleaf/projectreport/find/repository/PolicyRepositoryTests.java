package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
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
public class PolicyRepositoryTests {

    @Autowired
    private PolicyForProjectReportRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("약관 및 규정정책 식별번호 조회 테스트")
    public void findPolicyNo_test() {
        //given
        String policyName = "개인정보 수집 및 이용";

        //when
        int policyNo = repository.findPolicyNo(policyName);
        
        //then
        assertNotNull(policyNo);
        System.out.println("policyNo = " + policyNo);
    }
}
