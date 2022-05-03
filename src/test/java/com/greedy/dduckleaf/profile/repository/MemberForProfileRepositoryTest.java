package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.profile.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class
})
class MemberForProfileRepositoryTest {

    @Autowired
    private MemberForProfileRepository memberForProfileRepository;

    @Test
    public void initTest() {
        assertNotNull(memberForProfileRepository);
    }

    @Test
    @DisplayName("회원 번호로 이메일, 휴대전화번호 불러오기 테스트")
    public void findMemberTest() {

        //given
        int memberNo = 67;

        //when
        Member member = memberForProfileRepository.findById(67).get();

        //then
        System.out.println(member);
        assertNotNull(member);
    }

    @Test
    @DisplayName("회원 번호로 이메일, 전화번호 수정 테스트")
    @Transactional
    public void modifyMemberTest() {

        //given
        int memberNo = 67;
        String email = "tkdjawlwhs@gmail.com";
        String phone = "01012345678";

        //when
        Member member = memberForProfileRepository.findById(67).get();
        member.setEmail(email);
        member.setPhone(phone);

        //then
        Member foundMember = memberForProfileRepository.findById(67).get();
        System.out.println(foundMember.getPhone());
        assertEquals(foundMember.getPhone(), "01012345678");
    }

    @Test
    @DisplayName("이메일을 가진 회원 조회 실패 테스트")
    public void findMemberByEmailSuccessTest() {

        //given
        String email = "오늘 점싱은 냉모밀~";

        //when
        Member member = memberForProfileRepository.findMemberByEmail(email);

        //then
        System.out.println(member);
        assertNull(member);
    }

    @Test
    @DisplayName("이메일을 자니 회원 조회 성공 테스트")
    public void findMemberByEmailFailedTest(){

        //given
        String email = "tkdjawlwhs@naver.com";

        //when
        Member member = memberForProfileRepository.findMemberByEmail(email);

        //then
        System.out.println(member);
        assertNotNull(member);
    }

    @Test
    @DisplayName("해당 전화 번호를 가진 회원 찾기 테스트")
    public void findMemberByPhoneSuccessTest() {

        //given
        String phone = "01062019811";

        //when
        Member member = memberForProfileRepository.findMemberByPhone(phone);

        //then
        System.out.println(member);
        assertNotNull(member);
    }

    @Test
    @DisplayName("해당 전화 번호를 가진 회원 찾기 실패 테스트")
    public void findMemberByPhoneFailedTest() {

        //given
        String phone = "01099999999";

        //when
        Member member = memberForProfileRepository.findMemberByPhone(phone);

        //then
        System.out.println(member);
        assertNull(member);
    }
}