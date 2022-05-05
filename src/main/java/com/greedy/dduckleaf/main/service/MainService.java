package com.greedy.dduckleaf.main.service;

import com.greedy.dduckleaf.main.dto.MainPageDTO;
import com.greedy.dduckleaf.main.entity.Project;
import com.greedy.dduckleaf.main.repository.ProjectForMainRepository;
import com.greedy.dduckleaf.main.dto.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final ProjectForMainRepository projectForMainRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MainService(ProjectForMainRepository projectForMainRepository, ModelMapper modelMapper) {
        this.projectForMainRepository = projectForMainRepository;
        this.modelMapper = modelMapper;
    }

    public MainPageDTO findMainPage() {

        List<Project> foundDduckleafRecommendList = projectForMainRepository.findDduckleafRecommendList();
        List<Project> foundRankingList = projectForMainRepository.findRankingList();

        List<ProjectDTO> dduckleafRecommendList = foundDduckleafRecommendList.stream().map(project ->
                modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
        List<ProjectDTO> rankingList = foundRankingList.stream().map(project ->
                modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());

        return new MainPageDTO(dduckleafRecommendList, rankingList);
    }
}
