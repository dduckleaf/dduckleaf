package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.projectreport.find.dto.ProjectReportDTO;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectRepostService {

    private final ProjectReportRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectRepostService(ProjectReportRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ProjectReportDTO> findProjectReportListByMemberNo(int memberNo) {

        List<ProjectReport> reportList = repository.findByMemberNo(memberNo);

        return reportList.stream().map(projectReport -> modelMapper.map(projectReport, ProjectReportDTO.class)).collect(Collectors.toList());
    }
}
