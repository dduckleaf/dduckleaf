package com.greedy.dduckleaf.notice.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.entity.Notice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        DduckleafApplication.class
})
class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void initTest() {
        assertNotNull(noticeService);
    }

    @Test
    @DisplayName("공지사항 수정 테스트")
    @Transactional
    public void modifyNotice_test() {

        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeNo(10);
        noticeDTO.setNoticeName("테스트용제목");

        assertDoesNotThrow(()->noticeService.modifyNotice(noticeDTO));
    }

    @Test
    @DisplayName("공지사항 삭제 테스트")
    @Transactional
    public void removeNotice_test() {

        int noticeNo = 44;

        assertDoesNotThrow(()->noticeService.removeNotice(noticeNo));
    }
}