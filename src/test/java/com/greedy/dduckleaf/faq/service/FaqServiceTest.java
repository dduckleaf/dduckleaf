package com.greedy.dduckleaf.faq.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.dto.MemberDTO;
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

//    @Test
//    public void faqRegistTest(){
//
//        FaqDTO faqWrite = new FaqDTO();
//        faqWrite.setFaqNo(1);
//
//        MemberDTO member = new MemberDTO();
//        member.setMemberNo(1);
//
//
//        faqWrite.setFaqNo(faqWrite.getFaqNo());
////        faqregist.setFaqContent("content");
////        faqregist.setMember(member.getMemberNo());
//
//
//        service.faqnewRegist(faqWrite);
//    }

}