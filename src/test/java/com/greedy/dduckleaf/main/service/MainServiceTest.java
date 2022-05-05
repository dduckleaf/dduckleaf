package com.greedy.dduckleaf.main.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.main.dto.MainPageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class MainServiceTest {

    @Autowired
    private MainService mainService;

    @Test
    public void initTest() {
        assertNotNull(mainService);
    }

    @Test
    @DisplayName("메인 페이지에 보여줄 리스트 조회")
    public void findMainPageListTest() throws ParseException {

        //given

        //when
        MainPageDTO mainPage = mainService.findMainPage();

        //then
        System.out.println(mainPage);
        assertNotNull(mainPage);
    }
}