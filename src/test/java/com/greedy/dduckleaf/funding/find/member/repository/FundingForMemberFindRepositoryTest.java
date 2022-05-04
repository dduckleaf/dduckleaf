package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.funding.entity.Funding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FundingForMemberFindRepositoryTest {

    @Autowired
    private FundingForMemberFindRepository repo;

    @Test
    @DisplayName("init 테스트")
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    @DisplayName("PK로 Funding엔티티 조회 테스트")
    @Transactional
    public void findById_test() {
        Funding funding = repo.findById(4).get();
        assertNotNull(funding);

        System.out.println("funding = " + funding);
    }

    @Test
    @DisplayName("memberNo로 펀딩내역 조회 테스트")
    public void findByMemberNo_test() {

        //given
        int memberNo = 5;
        Pageable pageable = PageRequest.of(0, 10);

        //when
        Page<Funding> fundings = repo.findByMemberNo(memberNo, pageable);

        //then
        assertNotNull(fundings);
        fundings.forEach(funding -> {
            System.out.println("funding.getMemberNo() = " + funding.getMemberNo());
        });

    }
}