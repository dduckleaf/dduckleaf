package com.greedy.dduckleaf.platformqa.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.platformqa.entity.PlatformQa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        DduckleafApplication.class
})
class PlatformQaRepositoryTest {

    @Autowired
    private PlatformQaRepository repository;

    @Test
    public void initTest() {
        assertNotNull(repository);
    }

    @Test
    public void findAll_test() {
        List<PlatformQa> platformQaList = repository.findAll();

        assertNotNull(platformQaList);
        platformQaList.forEach(System.out::println);
    }
}