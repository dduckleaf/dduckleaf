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
}