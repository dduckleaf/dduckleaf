package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportSummaryInfoDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportCategoryDTO;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import com.greedy.dduckleaf.projectreport.find.repository.MemberForProjectReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectReportService {

    private final MemberForProjectReportRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectReportService(MemberForProjectReportRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ProjectReportDTO> findProjectReportListByMemberNo(int memberNo) {

        Member member = repository.findMemberByMemberNo(memberNo);

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
}
