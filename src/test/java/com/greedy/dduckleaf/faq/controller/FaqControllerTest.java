package com.greedy.dduckleaf.faq.controller;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {

        DduckleafApplication.class,
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class

})
class FaqControllerTest {

    @Autowired
    private FaqController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void initTest(){

        assertNotNull(controller);
        assertNotNull(mockMvc);
    }

//    @Test
//    @DisplayName("faq url 매핑 확인")
//    public void findProjectFaqList_test() throws Exception {
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("param1", "Test");
//        params.add("param2", "Another test");
//        params.add("param3", "123");
//        params.add("param4", "456");
//        return params;
//        Pageable pageable = PageRequest.of(1, 10);
//        mockMvc.perform(MockMvcRequestBuilders.get("/faq/list").param("pageable",pageable))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl("faq/list"))
//                .andDo(MockMvcResultHandlers.print());
//    }

}