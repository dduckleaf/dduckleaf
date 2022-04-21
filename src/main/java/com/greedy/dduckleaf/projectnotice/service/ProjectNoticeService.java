package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.projectnotice.dto.ProjectDTO;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.entity.Project;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import com.greedy.dduckleaf.projectnotice.repository.ProjectNoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectNoticeService(ProjectNoticeRepository projectNoticeRepository, ModelMapper modelMapper) {
        this.projectNoticeRepository = projectNoticeRepository;
        this.modelMapper = modelMapper;
    }

    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable, int projectNo) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());

        Page<ProjectNotice> projectNoticeList = projectNoticeRepository.findAllByProjectNo(projectNo, pageable);

        return projectNoticeRepository.findAllByProjectNo(projectNo, pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
    }

    public ProjectNoticeDTO findProjectNoticeDetail(int projectNoticeNo) {

        return projectNoticeRepository.findById(projectNoticeNo).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).get();
    }



}
