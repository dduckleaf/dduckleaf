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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectNoticeService {

//    private final ProjectRepository projectRepository;
    private final ProjectNoticeRepository projectNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectNoticeService(ProjectNoticeRepository projectNoticeRepository, ModelMapper modelMapper) {
//        this.projectRepository = projectRepository;
        this.projectNoticeRepository = projectNoticeRepository;
        this.modelMapper = modelMapper;
    }

    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable, int projectNo) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());
        System.out.println("pageable = " + pageable);

//        List<ProjectNotice> all = projectNoticeRepository.findAll();

        Page<ProjectNotice> projectNoticeList = projectNoticeRepository.findAllByProjectNo(projectNo, pageable);
//        System.out.println("서비스에선느 제대로 나오나? : " +  projectNoticeList);

//        Page<ProjectNoticeDTO> noticeList = (Page<ProjectNoticeDTO>) projectNoticeList.stream().map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
////        Page<ProjectNoticeDTO> noticeList = projectNoticeRepository.findAllByProjectNo(pageable, projectNo).stream().map(projectNotice -> ProjectNoticeDTO.class).map();
//
////        return projectNoticeList.stream().map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).collect(Collectors.toList());
////        return projectNoticeRepository.findAllByProjectNo(pageable, projectNo).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
        return projectNoticeRepository.findAllByProjectNo(projectNo, pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
//        return noticeList;
    }
    

//    public List<ProjectDTO> findAll() {
//
//        List<Project> projectList = projectRepository.findAll();
//
//        return projectList.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
//    }
    
    

}
