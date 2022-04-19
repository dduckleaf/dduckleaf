package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.repository.FarmerInfoRepository;
import com.greedy.dduckleaf.projectnotice.repository.ProjectNoticeRepository;
import com.greedy.dduckleaf.projectnotice.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ProjectNoticeService<ProjectNoticeMapper> {

    private final FarmerInfoRepository farmerInfoRepository;
    private final ProjectRepository projectRepository;
    private final ProjectNoticeRepository projectNoticeRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ProjectNoticeService(FarmerInfoRepository farmerInfoRepository, ProjectRepository projectRepository,
                                ProjectNoticeRepository projectNoticeRepository, ModelMapper modelMapper) {

        this.farmerInfoRepository = farmerInfoRepository;
        this.projectRepository = projectRepository;
        this.projectNoticeRepository = projectNoticeRepository;
        this.modelMapper = modelMapper;

    }

    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());

        return projectNoticeRepository.findAll(pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
    }

}
