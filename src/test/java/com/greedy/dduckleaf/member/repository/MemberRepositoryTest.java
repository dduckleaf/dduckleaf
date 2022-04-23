package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
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
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void  initTest() {
        assertNotNull(memberRepository);
        assertNotNull(javaMailSender);
    }

    @Test
    @DisplayName("이메일 중복 체크 중복의 경우")
    public void emailDupleTest() {

        //given
        String email = "USER01@GMAIL.COM";

        //when
        List<Member> member = memberRepository.findMemberByEmail(email);

        //then
        assertNotNull(member);
        member.forEach(System.out::println);
    }

    @Test
    @DisplayName("이메일 중복 체크 중복이 아닌 경우")
    public void emailNotDupleTest() {

        //given
        String email = "sangbum0313@nate.com";

        //when
        List<Member> member = memberRepository.findMemberByEmail(email);

        //then
        assertEquals(member.size(),0);
    }
}