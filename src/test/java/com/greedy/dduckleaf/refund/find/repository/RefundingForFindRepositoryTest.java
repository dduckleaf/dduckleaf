package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.find.entity.Refunding;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
class RefundingForFindRepositoryTest {

    @Autowired
    private RefundingForFindRepository repo;
    @Autowired
    private ModelMapper mapper;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    public void findByMemberNo_test() {

        //given
        int memberNo = 3;
        Pageable pageable = PageRequest.of(0, 10);

        //when
        Page<Refunding> refundings = repo.findByMemberNo(memberNo, pageable);

        //then
        assertNotNull(refundings);
        refundings.forEach(System.out::println);
    }

    @Test
    public void findById_test() {

        //given
        int refundingNo = 31;

        //when
        Refunding refunding = repo.findById(refundingNo).get();

        //then
        assertNotNull(refunding);
        System.out.println("refunding = " + refunding);
    }

    @Test
    public void findByProject_farmerNo_test() {

        //given
        int farmerNo = 8;

        //when
        List<Refunding> refundings = repo.findByProject_farmerNo(farmerNo);

        //then
        assertNotNull(refundings);
        refundings.forEach(System.out::println);
    }

    @Test
    public void findByProject_projectNo_test() {

        //given
        int projectNo = 343;
        Pageable pageable = PageRequest.of(0, 10);

        //when
        Page<Refunding> refundings = repo.findByProject_projectNo(projectNo, pageable);

        //then
        assertNotNull(refundings);
        refundings.forEach(System.out::println);

        Page<RefundingDTO> dtos = refundings.map(refund -> mapper.map(refund, RefundingDTO.class));
        dtos.forEach(System.out::println);
    }
}