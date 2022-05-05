package com.greedy.dduckleaf.myfunding.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.myfunding.entity.MockFundJoinHistory;
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
class MockFundJoinHistoryForMyFundingRepositoryTest {

    @Autowired
    private MockFundJoinHistoryForMyFundingRepository mockFundJoinHistoryForMyFundingRepository;

    @Test
    public void initTest(){
        assertNotNull(mockFundJoinHistoryForMyFundingRepository);
    }

    @Test
    @DisplayName("회원번호로 모의펀딩내역 조회")
    public void findMockFundJoinHistoryTest() {

        //given
        int memberNo = 5;

        //when
        List<MockFundJoinHistory> mockFundJoinHistoryList = mockFundJoinHistoryForMyFundingRepository.findByMember_memberNo(memberNo);

        //then
        assertEquals(mockFundJoinHistoryList.size(), 0);
    }
}