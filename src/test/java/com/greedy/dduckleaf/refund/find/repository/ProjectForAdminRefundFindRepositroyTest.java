package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.ContextConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.refund.find.entity.ProjectForAdminList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        ContextConfiguration.class,
        DduckleafApplication.class
})
class ProjectForAdminRefundFindRepositroyTest {

    @Autowired
    private ProjectForAdminRefundFindRepositroy repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void finaAll_test() {

        //when
        List<ProjectForAdminList> list = repo.findAll();

        //then
        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    public void finaAll_Paging_test() {

        //given
        Pageable pageable = PageRequest.of(0, 10);

        //when
        Page<ProjectForAdminList> projects = repo.findAll(pageable);

        //when
        assertNotNull(projects);
        projects.forEach(System.out::println);
    }
}