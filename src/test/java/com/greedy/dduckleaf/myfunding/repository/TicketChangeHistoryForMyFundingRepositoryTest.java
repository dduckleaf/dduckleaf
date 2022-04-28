package com.greedy.dduckleaf.myfunding.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.myfunding.entity.TicketChangeHistory;
import org.junit.jupiter.api.DisplayName;
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
        JPAConfiguration.class,
        DduckleafApplication.class
})
class TicketChangeHistoryForMyFundingRepositoryTest {

    @Autowired
    private TicketChangeHistoryForMyFundingRepository ticketChangeHistoryForMyFundingRepository;

    @Test
    public void initTest() {
        assertNotNull(ticketChangeHistoryForMyFundingRepository);
    }

    @Test
    @DisplayName("회원의 현재 티켓 갯수 구하기 테스트")
    public void currentTicketAmountTest() {

        //given
        int memberNo = 5;

        //when
        List<TicketChangeHistory> ticketChangeHistoryList = ticketChangeHistoryForMyFundingRepository.findByMember_memberNo(memberNo);

        //then
        assertEquals(ticketChangeHistoryList.size(), 0);
    }
}