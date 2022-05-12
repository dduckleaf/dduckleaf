package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class MemberCategoryForMemberRepositoryTest {

    @Autowired
    private MemberCategoryForMemberRepository memberCategoryForMemberRepository;

    @Test
    public void test() {
        assertNotNull(memberCategoryForMemberRepository);
    }

//    @Test
//    @DisplayName("역할 번호로 권한 목록 조회")
//    public void findBymemberRoleTest() {
//
//        //given
//        int memberRole = 1;
//
//        //when
//
//
//        //then
//
//
//    }
}