package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
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
        DduckleafApplication.class,
        JPAConfiguration.class
})
class ProfileAttachmentForProfileRepositoryTest {

    @Autowired
    private ProfileAttachmentForProfileRepository profileAttachmentForProfileRepository;

    @Test
    public void initTest() {
        assertNotNull(profileAttachmentForProfileRepository);
    }

    @Test
    @DisplayName("프로필 사진 조회 테스트")
    @Transactional
    public void findProfileAttachmentTest() {

        //given
        int memberNo = 5;

        //when
        ProfileAttachment profileAttachment = profileAttachmentForProfileRepository.findProfileAttachmentByMember_memberNo(memberNo);

        //then
        System.out.println(profileAttachment);
        assertNotNull(profileAttachment);
    }
}