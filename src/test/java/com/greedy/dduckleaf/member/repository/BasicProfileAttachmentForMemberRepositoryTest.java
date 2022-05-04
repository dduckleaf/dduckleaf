package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.member.entity.BasicProfileAttachment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class
})
class BasicProfileAttachmentForMemberRepositoryTest {

    @Autowired
    private BasicProfileAttachmentForMemberRepository basicProfileAttachmentForMemberRepository;

    @Test
    public void initTest() {
        assertNotNull(basicProfileAttachmentForMemberRepository);
    }

    @Test
    public void findTest() {

        //given
        int basicProfileAttachmentNo = 1;

        //when
        BasicProfileAttachment basicProfileAttachment = basicProfileAttachmentForMemberRepository.findById(basicProfileAttachmentNo).get();

        //then
        System.out.println(basicProfileAttachment);
        assertNotNull(basicProfileAttachment);
    }
}