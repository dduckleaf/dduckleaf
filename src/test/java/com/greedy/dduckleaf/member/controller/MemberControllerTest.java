package com.greedy.dduckleaf.member.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.config.SpringSecurityConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        BeanConfiguration.class,
        SpringSecurityConfiguration.class
})
class MemberControllerTest {

    @Autowired
    private MemberController memberController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void intiTest() {
        assertNotNull(memberController);
        assertNotNull(mockMvc);
    }
}