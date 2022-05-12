package com.greedy.dduckleaf.faq.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.faq.dto.FaqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaRepository.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FaqServiceTest {

    @Autowired
    private FaqService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

    @Test
    public void findFaqListTest(){

        Pageable pageable = PageRequest.of(1, 10);
        Page<FaqDTO> fq= service.findFaqList(pageable);
        assertNotNull(fq);
        fq.forEach(System.out::println);
    }
}