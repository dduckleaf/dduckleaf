package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import com.greedy.dduckleaf.projectnotice.repository.ProjectNoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectNoticeService(ProjectNoticeRepository projectNoticeRepository, ModelMapper modelMapper) {

        this.projectNoticeRepository = projectNoticeRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProjectNoticeDTO> selectProjectNoticeList() {

        List<ProjectNotice> projectNoticeList = projectNoticeRepository.findAll();

        System.out.println("projectNoticeList = " + projectNoticeList);

        return projectNoticeList.stream().map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).collect(Collectors.toList());
    }

//    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable) {
//
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
//                pageable.getPageSize(),
//                Sort.by("projectNoticeNo").descending());
//
////        List<ProjectNotice> projectNoticeList = projectNoticeRepository.findAll();
//        return projectNoticeRepository.findAll(pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
////        return projectNoticeList.stream().map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).collect(Collectors.toList());
//    }

//    public MemberDTO selectMemberNoById(String id) {
//
//
////        Member farmer = projectNoticeRepository.findById(id);
//    }
}
