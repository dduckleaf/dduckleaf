package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.entity.PolicyContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class PolicyContentRepositoryTests {

    @Autowired
    private PolicyContentForProjectReportRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("개인정보 수집 및 이용동의 약관 조회 테스트")
    public void findAllByPolicy_PolicyNo_test() {
        //given
        int policyNo = 1;

        //when
        List<PolicyContent> policyContents = repository.findAllByPolicy_PolicyNo(policyNo);

        //then
        assertNotNull(policyContents);
        policyContents.forEach(System.out::println);
    }
}
