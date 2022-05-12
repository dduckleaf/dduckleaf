package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.Member;
import com.greedy.dduckleaf.funding.entity.MemberForAdmin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class MemberForFundingFindRepositoryTest {

    @Autowired
    private MemberForFundingFindRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("전체조회 테스트")
    public void findAll_test() {

        //when
        List<MemberForAdmin> members = repo.findAll();

        //then
        assertNotNull(members);
        members.forEach(System.out::println);
    }
}