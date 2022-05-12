package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
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
