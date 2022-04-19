package com.greedy.dduckleaf.projectreport.repository;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {DduckleafApplication.class, ContextConfiguration.class,
        BeanConfiguration.class, JPAConfiguration.class, SpringSecurityConfiguration.class})
public class ProjectReportRepositoryTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProjectReportRepository repository;

    @Test
    public void initTest() {
        assertNotNull(entityManager);
        assertNotNull(repository);
    }
}
