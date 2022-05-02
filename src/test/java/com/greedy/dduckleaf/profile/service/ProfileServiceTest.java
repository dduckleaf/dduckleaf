package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.projectnotice.dto.ProfileDTO;
import org.junit.jupiter.api.DisplayName;
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
class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Test
    public void initTest() {
        assertNotNull(profileService);
    }

    @Test
    @DisplayName("회원 번호로 프로필 정보와 회원 정보를 조회")
    public void findMemberTest() {

        //given
        int memberNo = 67;

        //when
        ProfileDTO profile = profileService.findProfileByMemberNo(memberNo);

        //then
        System.out.println(profile);
        assertNotNull(profile);
    }

    @Test
    @DisplayName("이메일 변경 인증번호 전송 - 사용중인 이메일인 경우 테스트")
    public void sendEmailVerificationUsingTest() {

        //given
        String email = "sangbum@naver.com";

        //when
        String result = profileService.sendEmailVerification(email);

        //then
        System.out.println(result);
        assertEquals(result,"이미 사용중인 이메일 입니다.");
    }

    @Test
    @DisplayName("이메일 변경 인증번호 전송 테스트")
    public void sendEmailverificationTest() {

        //given
        String email = "sangbum0497@naver.com";

        //when
        String result = profileService.sendEmailVerification(email);

        //then
        System.out.println(result);
        assertNotEquals(result, "이미 사용중인 이메일 입니다.");
    }

}