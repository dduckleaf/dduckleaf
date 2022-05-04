package com.greedy.dduckleaf.refund.regist.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class RefundingRegistServiceTest {

    @Autowired
    private RefundingRegistService service;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    public void registRefunding_test() {




    }

}









































