package com.greedy.dduckleaf.platformqa.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaCategoryDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        DduckleafApplication.class
})
class PlatformQaServiceTest {

    @Autowired
    PlatformQaService platformQaService;

    @Test
    public void initTest() {

        assertNotNull(platformQaService);
    }

    @Test
    @DisplayName("1:1문의 카테고리 목록조회 테스트")
    public void test() {

        //given

        //when
        List<PlatformQaCategoryDTO> platformQaCategoryList = platformQaService.findAllPlatformQaCategory();

        //then
        assertNotNull(platformQaCategoryList);
        platformQaCategoryList.forEach(System.out::println);

    }

}