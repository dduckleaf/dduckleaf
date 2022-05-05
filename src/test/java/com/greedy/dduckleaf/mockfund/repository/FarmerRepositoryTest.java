package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.mockfund.entity.Farmer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        JPAConfiguration.class
})
class FarmerRepositoryTest {

    @Autowired
    private FarmerRepository farmerRepository;

    @Test
    public void initTest() {
        assertNotNull(farmerRepository);
    }
    
    @Test
    @DisplayName("파머 정보 조회")
    public void findFarmerTest() {
        
        //given
        int memberNo = 3;
        
        //when
        Farmer farmer = farmerRepository.findById(memberNo).get();
        
        //then
        assertNotNull(farmer);
        System.out.println("farmer = " + farmer);
    }

}