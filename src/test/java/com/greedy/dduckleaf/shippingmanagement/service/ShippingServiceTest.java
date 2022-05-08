package com.greedy.dduckleaf.shippingmanagement.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class ShippingServiceTest {

    @Autowired
    private ShippingService shippingService;

    @Test
    public void initTest() {
        assertNotNull(shippingService);
    }

    @Test
    public void findProjectListByMemberNoTest() {

        //given
        int memberNo = 5;

        //when
        List<ProjectDTO> projectList = shippingService.findProjectListByMemberNo(memberNo);

        //then
        assertNotNull(projectList);
        projectList.forEach(System.out::println);
    }

}