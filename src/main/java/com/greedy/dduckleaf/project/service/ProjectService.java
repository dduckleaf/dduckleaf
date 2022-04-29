package com.greedy.dduckleaf.project.service;

import com.greedy.dduckleaf.project.dto.ProjectDTO;
import com.greedy.dduckleaf.project.entity.Project;
import com.greedy.dduckleaf.project.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : ProjectService
 * Comment : 프로젝트
 * History
 * 2022-04-27 (차화응) 처음 작성 / 개별 프로젝트 상세조회 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    public ProjectDTO findProjectDetail(int projectNo) {

//        Project project = projectRepository.findByProjectNoAndProgressStatus(projectNo, 2);

        Project project = projectRepository.findById(projectNo).get();

        return modelMapper.map(project, ProjectDTO.class);
    }
}
