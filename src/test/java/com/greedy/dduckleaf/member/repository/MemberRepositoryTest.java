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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
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

    @Test
    @DisplayName("입력한 아이디와 이메일로 회원가입여부 확인 성공")
    public void findMemberByMemberIdAndEmailSuccessTest() {

        //given
        String memberId = "qwer";
        String email = "tkdjawlwhs@naver.com";

        //when
        Member member = memberRepository.findMember(memberId, email);

        //then
        assertNotNull(member);
        System.out.println(member);
    }

    @Test
    @DisplayName("입력한 아이디와 이메일로 회원가입여부 확인 실패")
    public void findMemberByMemberAndEmailFailedTest() {

        //given
        String memberId = "asdf";
        String email = "tkdjawlwhs@naver.com";

        //when
        Member member = memberRepository.findMember(memberId, email);

        //then
        assertNull(member);
    }

    @Test
    @DisplayName("회원번호로 비밀번호 변경")
    @Transactional
    public void modifyMemberPwd() {

        //given
        int memberNo = 67;
        String memberPwd = "@@@@@@@@@@@@@@@@@@@@@@@@@@";

        //when
        Member member = memberRepository.findMemberByMemberNo(memberNo);
        member.setMemberPwd(memberPwd);

        //then
        Member findMember = memberRepository.findById(67).get();
        assertEquals(findMember.getMemberPwd(), "@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    @Test
    @DisplayName("회원 탈퇴 여부 확인 테스트")
    public void findByMemberIdAndWithdrawalStatusTest() {

        //given
        String memberId = "USER03";

        //when
        Member member = memberRepository.findByMemberIdAndWithdrawalStatus(memberId, "N");

        //then
        System.out.println(member);
        assertNotNull(member);
    }

    @Test
    public void test() {

        //given


        //when
        Member member = memberRepository.findById(3).get();

        //then
        System.out.println(member);
        assertNotNull(member);

    }
}