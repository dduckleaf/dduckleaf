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
        Member member = memberRepository.findMemberByEmail(email);

        //then
        assertNotNull(member);
    }

    @Test
    @DisplayName("이메일 중복 체크 중복이 아닌 경우")
    public void emailNotDupleTest() {

        //given
        String email = "sangbum0313@nate.com";

        //when
        Member member = memberRepository.findMemberByEmail(email);

        //then
        assertNull(member);
    }

    @Test
    @DisplayName("휴대폰 번호 중복 체크 중복인 경우")
    public void phoneDupleTest() {

        //given
        String phone = "01065524838";

        //when
        Member member = memberRepository.findMemberByPhone(phone);

        //then
        assertNotNull(member);
    }

    @Test
    @DisplayName("휴대폰 번호 중복 체크 중복이 아닌 경우")
    public void phoneNotDupleTest() {

        //given
        String phone = "01038109897";

        //when
        Member member = memberRepository.findMemberByPhone(phone);

        //then
        assertNull(member);
    }

    @Test
    @DisplayName("아이디 찾기 테스트")
    public void loginTest() {

        //given
        String memberId = "admin";

        //when
        Member member = memberRepository.findMemberByMemberId(memberId);

        //then
        assertNotNull(member);
    }

    @Test
    @DisplayName("이메일로 아이디 찾기")
    public void findMemberIdByEmailTest() {

        //given
        String email = "tkdjawlwhs@naver.com";

        //when
        String memberId = memberRepository.findMemberByEmail(email).getMemberId();

        //then
        assertNotNull(memberId);
        System.out.println(memberId);
    }
}