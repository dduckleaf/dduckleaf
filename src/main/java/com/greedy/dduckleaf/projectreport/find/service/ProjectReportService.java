package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportCategoryDTO;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import com.greedy.dduckleaf.projectreport.find.repository.MemberForProjectReportRepository;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ProjectReportService
 * Comment : 프로젝트신고 업무에 사용되는 트랜젝션 메소드를 작성하였습니다.
 *
 * History
 * 2022-04-19 회원정보로 접근하여 프로젝트 신고내역 목록 조회용 서비스메소드 작성
 * 2022-04-23 전체 프로젝트 신고내역 목록 조회용 서비스메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.1
 */
@Service
public class ProjectReportService {

    private final MemberForProjectReportRepository memberRepository;
    private final ProjectReportRepository reportRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectReportService(MemberForProjectReportRepository memberRepository, ProjectReportRepository reportRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProjectReportDTO> findProjectReportListByMemberNo(int memberNo) {

        Member member = memberRepository.findMemberByMemberNo(memberNo);

        List<ProjectReport> projectReportList = member.getProjectReportList();

        /* 프로젝트 리스트 추출 */
        List<Project> projectList = new ArrayList<>();
        for(ProjectReport report : projectReportList) {
            projectList.add(report.getProject());
        }
        System.out.println("projectList = " + projectList);

        /* 카테고리 리스트 추출 */
        List<ReportCategory> reportCategoryList = new ArrayList<>();
        for(ProjectReport report : projectReportList) {
            reportCategoryList.add(report.getReportCategory());
        }
        System.out.println("reportCategoryList = " + reportCategoryList);

        /* 영속성을 해제하기 위해 projectList와 reportCategoryList, projetReportList를 각각 DTO타입으로 parsing한다. */
        List<ProjectDTO> projectDTOList = projectList.stream().map(project ->
                modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());

        List<ReportCategoryDTO> reportCategoryDTOList = reportCategoryList.stream().map(reportCategory ->
                modelMapper.map(reportCategory, ReportCategoryDTO.class)).collect(Collectors.toList());

        List<ProjectReportDTO> projectReportDTOList = projectReportList.stream().map(projectReport ->
                modelMapper.map(projectReport, ProjectReportDTO.class)).collect(Collectors.toList());

        System.out.println("projectReportDTOList = " + projectReportDTOList);
        System.out.println("projectDTOList = " + projectDTOList);
        System.out.println("reportCategoryDTOList = " + reportCategoryDTOList);

        for(int i = 0; i < projectDTOList.size(); i++) {
            /* projectDTO 리스트를 한행씩 꺼내 projectReportDTO에 각각 set한다. */
            projectReportDTOList.get(i).setProject(projectDTOList.get(i));
            /* reportCategoryDTO 리스트를 한행씩 꺼내 projectReportDTO에 각각 set한다. */
            projectReportDTOList.get(i).setReportCategory(reportCategoryDTOList.get(i));
        }
        projectReportDTOList.forEach(System.out::println);

        return projectReportDTOList;
    }

    /**
    * 메소드에 관한 설명
    *  @param pageable: 페이징에 필요한 정보를 담는 객체
    * @return 페이징 처리가 된 조회 결과를 DTO로 변환한 프로젝트신고목록
    */
    public Page<ProjectReportDTO> findProjectReportList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectReportNo").descending());

        return reportRepository.findAll(pageable).map(projectReport -> modelMapper.map(projectReport, ProjectReportDTO.class));
    }
}
