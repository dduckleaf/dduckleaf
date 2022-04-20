package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.config.*;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes = {
        DduckleafApplication.class,
        ContextConfiguration.class,
        BeanConfiguration.class,
        JPAConfiguration.class,
        SpringSecurityConfiguration.class
})
public class ProjectReportServiceTests {

    @Autowired
    private ProjectRepostService service;

    @Autowired
    private ProjectReportRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {
        assertNotNull(service);
        assertNotNull(repository);
        assertNotNull(modelMapper);
    }

    @Test
    @DisplayName("서포터 프로젝트신고내역 목록조회 테스트")
    public void findProjectReportListByMemberNo_test() {
        //given
        int memberNo = 3;

        //when
        List<ProjectReportDTO> reportList = service.findProjectReportListByMemberNo(memberNo);

        //then
        assertNotNull(reportList);
        reportList.forEach(System.out::println);
    }
}
