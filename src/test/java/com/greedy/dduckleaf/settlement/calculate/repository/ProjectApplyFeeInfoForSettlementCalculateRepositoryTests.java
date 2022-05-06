package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.settlement.calculate.entity.ProjectApplyFeeInfo;
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
public class ProjectApplyFeeInfoForSettlementCalculateRepositoryTests {

    @Autowired
    private ProjectApplyFeeInfoForSettlementCalculateRepository repository;

    @Test
    public void initTest() { assertNotNull(repository); }

    @Test
    @DisplayName("프로젝트에 적용된 수수료정책 조회 테스트")
    public void findByProjectNo_test() {

        //given
        int projectNo = 1;

        //when
        ProjectApplyFeeInfo feeInfo = repository.findByProjectNo(projectNo);

        //then
        assertNotNull(feeInfo);
        System.out.println("feeInfo = " + feeInfo);
    }
}
