package com.greedy.dduckleaf.profile.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
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
    @DisplayName("회원 번호로 프로필 정보를 조회")
    public void findMemberTest() {

        //given
        int memberNo = 67;

        //when
        ProfileDTO profile = profileService.findProfileByMemberNo(memberNo);

        //then
        System.out.println(profile);
        assertNotNull(profile);
    }
}