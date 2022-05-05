package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * Class : BankRepositoryTest
 * Comment :
 *
 * History
 * 2022-04-22 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class BankRepositoryTest {

    @Autowired
    private BankRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("은행명 전체 조회 테스트")
    public void findAllBank() {
        List<Bank> bankList = repo.findAll();
        assertNotNull(bankList);
        bankList.forEach(System.out::println);
    }

}