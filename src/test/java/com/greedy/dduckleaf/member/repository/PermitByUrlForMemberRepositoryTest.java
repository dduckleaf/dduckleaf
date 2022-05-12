package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.member.entity.PermitByUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class PermitByUrlForMemberRepositoryTest {

    @Autowired
    private PermitByUrlForMemberRepository permitByUrlForMemberRepository;

    @Test
    public void initTest() {
        assertNotNull(permitByUrlForMemberRepository);
    }

    @Test
    @DisplayName("모든 url 조회 테스트")
    public void findALlTest() {

        //given

        //when
        List<PermitByUrl> permitByUrlList = permitByUrlForMemberRepository.findAll();

        //then
        permitByUrlList.forEach(System.out::println);
        assertNotNull(permitByUrlList);
    }

    @Test
    @DisplayName("역할 번호로 권한 목록 조회 테스트")
    public void findByPermitListTest() {

        //given
        int memberRole = 1;

        //when
        List<PermitByUrl> permitByUrlList = permitByUrlForMemberRepository.findByMemberRole(memberRole);

        //then
        permitByUrlList.forEach(System.out::println);
        assertNotNull(permitByUrlList);
    }
}