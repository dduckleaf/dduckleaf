package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.Funding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * Class : FundingRepositoryTest
 * Comment :
 *
 * History
 * 2022-04-24 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class
})
class FundingRepositoryTest {

    @Autowired
    private FundingRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @Transactional
    public void 펀딩신청정보_삽입_테스트() {
        Funding funding = new Funding();



    }


}

































