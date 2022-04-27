package com.greedy.dduckleaf.faq.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.faq.entity.Faq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaRepository.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FaqRepositoryTest {

    @Autowired
    private FaqRepository faqRepository;

    @Test
    public void initTest(){
        assertNotNull(faqRepository);
    }


    @Test
    public void listTest(){

        List<Faq> faqList = faqRepository.findAll();
        assertNotNull(faqList);
        faqList.forEach(System.out::println);
    }
}