package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.profile.dto.ProfileDTO;
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

    @Test
    @DisplayName("휴대전화 번호 인증번호 전송 테스트")
    public void sendPhoneVerificationSuccessTest() {

        //given
        String phone = "01038109897";

        //when
        String result = profileService.sendPhoneVerification(phone);

        //then
        System.out.println(result);
        assertNotEquals(result, "휴대전화 번호를 입력해주세요.");
        assertNotEquals(result, "이미 사용중인 휴대전화 번호입니다.");
    }

    @Test
    @DisplayName("휴대전화 번호 인증번호 전송 - 휴대전화 번호를 입력하지 않았을 경우")
    public void sendPhoneVerificationIsBlankTest() {

        //given
        String phone = "";

        //when
        String result = profileService.sendPhoneVerification(phone);

        //then
        System.out.println(result);
        assertEquals(result, "휴대전화 번호를 입력해주세요.");
    }

    @Test
    @DisplayName("휴대전화 번호 인증번호 전송 - 이미 사용중인 전화번호인 경우")
    public void sendPhoneVerificationExistTest() {

        //given
        String phone = "01062019811";

        //when
        String result = profileService.sendPhoneVerification(phone);

        //then
        System.out.println(result);
        assertEquals(result, "이미 사용중인 휴대전화 번호입니다.");
    }

    @Test
    @DisplayName("프로필 이미지 삭제 실패 테스트")
    public void removeProfileAttachmentTest() {

        //given
        int memberNo = 67;

        //when
        String result = profileService.removeProfileAttachment(memberNo);

        //then
        assertEquals(result, "프로필 사진 삭제 실패");
    }

    @Test
    @DisplayName("프로필 이미지 삭제 - 기본 이미지로 변경 테스트")
    public void removeProfileAttachmentBasicTest() {

        //given
        int memberNo = 5;

        //when
        String result = profileService.removeProfileAttachment(memberNo);

        //then
        assertEquals(result, "기본 이미지로 변경되었습니다.");
    }
}