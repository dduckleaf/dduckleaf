package com.greedy.dduckleaf.projectapplication.projectexamination.service;

import com.greedy.dduckleaf.projectapplication.dto.FarmerInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.entity.FarmerInfo;
import com.greedy.dduckleaf.projectapplication.entity.ProjectApplicationInfo;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.FarmerInfoForProjectApplicationRepository;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.ProjectApplicationInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class: ProjectExaminationService
 * Comment : 프로젝트 심사
 * History
 * 2022/05/02 (박휘림) findProjectApplicationList  메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
@Service
public class ProjectExaminationService {

    private final ModelMapper modelMapper;
    private final ProjectApplicationInfoRepository projectApplicationInfoRepository;
    private final FarmerInfoForProjectApplicationRepository farmerRepository;


    @Autowired
    public ProjectExaminationService(ModelMapper modelMapper, ProjectApplicationInfoRepository projectApplicationInfoRepository, FarmerInfoForProjectApplicationRepository farmerRepository) {
        this.modelMapper = modelMapper;
        this.projectApplicationInfoRepository = projectApplicationInfoRepository;
        this.farmerRepository = farmerRepository;
    }

    public Page<ProjectApplicationInfoDTO> findProjectApplicationList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectApplicationNo").descending());

        Page<ProjectApplicationInfo> applicationInfoList = projectApplicationInfoRepository.findAll(pageable);
        applicationInfoList.forEach(System.out::println);

        return projectApplicationInfoRepository.findAll(pageable).map(projectApplicationInfo -> modelMapper.map(projectApplicationInfo, ProjectApplicationInfoDTO.class));
    }




}
