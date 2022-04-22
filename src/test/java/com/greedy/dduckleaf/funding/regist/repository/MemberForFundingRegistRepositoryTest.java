package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.regist.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes = {
        DduckleafApplication.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class MemberForFundingRegistRepositoryTest {
    @Autowired
    private MemberForFundingRegistRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void findMemberById_test() {
        String memberId = "USER01";
        Member member = repo.findByMemberId(memberId);

        System.out.println("member = " + member);
        assertNotNull(member);
    }

}




