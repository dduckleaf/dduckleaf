package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportSummeryInfoDTO;
import com.greedy.dduckleaf.projectreport.find.dto.ReportCategoryDTO;
import com.greedy.dduckleaf.projectreport.find.entity.Member;
import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import com.greedy.dduckleaf.projectreport.find.repository.MemberForProjectReportRepository;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectReportService {

    private final ProjectReportRepository repository2;
    private final MemberForProjectReportRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectReportService(ProjectReportRepository repository2, MemberForProjectReportRepository repository, ModelMapper modelMapper) {
        this.repository2 = repository2;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ProjectReportSummeryInfoDTO> findProjectReportListByMemberNo(int memberNo) {

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
            System.out.println("뭐가들었는지 확인 : " + projectReportDTOList.get(i).getProject());
            projectReportDTOList.get(i).setProject(projectDTOList.get(i));
            projectReportDTOList.get(i).setReportCategory(reportCategoryDTOList.get(i));
        }
        projectReportDTOList.forEach(System.out::println);

        List<ProjectReportSummeryInfoDTO> projectReportSummeryInfo = new ArrayList<>();
        for(int i = 0; i < projectReportSummeryInfo.size(); i++) {
            projectReportSummeryInfo.get(i).setProjectReport(projectReportDTOList.get(i));
            projectReportSummeryInfo.get(i).setProject(projectDTOList.get(i));
            projectReportSummeryInfo.get(i).setReportCategory(reportCategoryDTOList.get(i));
        }
        projectReportSummeryInfo.forEach(System.out::println);

        return projectReportSummeryInfo;
    }
}
