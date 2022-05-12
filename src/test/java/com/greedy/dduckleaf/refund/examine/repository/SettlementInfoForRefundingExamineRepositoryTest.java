package com.greedy.dduckleaf.refund.examine.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.ContextConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.examine.entity.SettlementInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        ContextConfiguration.class
})
class SettlementInfoForRefundingExamineRepositoryTest {

    @Autowired
    private SettlementInfoForRefundingExamineRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    public void findAll_test() {

        //when
        List<SettlementInfo> infos = repo.findAll();

        //then
        assertNotNull(infos);
        infos.forEach(System.out::println);
    }

    @Test
    public void findByProjectNo_test() {

        //given
        int projectNo = 1;

        //when
        SettlementInfo info = repo.findByProjectNo(projectNo);

        //then
        assertNotNull(info);
        System.out.println("info = " + info);
        System.out.println("info.getSettlementInfoNo() = " + info.getSettlementInfoNo());
    }
}