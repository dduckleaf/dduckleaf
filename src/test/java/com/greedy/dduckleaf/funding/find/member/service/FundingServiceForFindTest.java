package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * Class : FundingServiceForFindTest
 * Comment : FundingServiceForFind 클래스에 작성된 메소드를 단위테스트하는 클래스입니다.
 *
 * History
 * 2022-04-25 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaRepository.class,
        DduckleafApplication.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class
})
class FundingServiceForFindTest {

    @Autowired
    private FundingServiceForFind service;

    @Test
    @DisplayName("FundingServiceForFind 의존성주입 테스트")
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    @DisplayName("MemberNo로 Funding List 조회 테스트")
    public void findFundingByMemberNo_test() {
        //given
        int memberNo = 5;

        //when
        List<FundingDTO> fundingList =  service.findFundingByMemberNo(memberNo);

        //then
        assertNotNull(fundingList);
        fundingList.forEach(System.out::println);
    }
}