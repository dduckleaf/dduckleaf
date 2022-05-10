package com.greedy.dduckleaf.admin.sevice;

import com.greedy.dduckleaf.admin.dto.DashBoardDTO;
import com.greedy.dduckleaf.admin.repository.FundingInfoForAdminRepository;
import com.greedy.dduckleaf.config.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void initTest() {
        assertNotNull(adminService);
    }

    @Test
    @DisplayName("관리자 대시보드 조회 테스트")
    public void findDashBoardTest() {

        //given

        //when
        DashBoardDTO dashBoard = adminService.findDashBoard();

        //then
        System.out.println(dashBoard);
        assertNotNull(dashBoard);
    }
}