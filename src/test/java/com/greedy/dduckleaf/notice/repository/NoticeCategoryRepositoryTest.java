package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.notice.entity.NoticeCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        DduckleafApplication.class
})
class NoticeCategoryRepositoryTest {

    @Autowired
    private NoticeCategoryRepository noticeCategoryRepository;
    @Test
    public void initTest() {

        assertNotNull(noticeCategoryRepository);
    }

    @Test
    @DisplayName("공지사항 카테고리 조회 테스트")
    public void findNoticeCategory_test() {

        List<NoticeCategory> noticeCategoryList = noticeCategoryRepository.findAllNoticeCategory();

        noticeCategoryList.forEach(System.out::println);

        assertNotNull(noticeCategoryList);
    }
}