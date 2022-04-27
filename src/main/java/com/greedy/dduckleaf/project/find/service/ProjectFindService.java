package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.entity.Project;
import com.greedy.dduckleaf.project.find.repository.ProjectForProjectListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ProjectListService
 * Comment :
 *
 * History
 * 2022-04-27 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Service
public class ProjectFindService {

    private final static int PROJECT_LIST_STATUS = 2;
    private final ProjectForProjectListRepository projectRepo;
    private final ModelMapper mapper;

    @Autowired
    public ProjectFindService(ProjectForProjectListRepository projectRepo, ModelMapper mapper) {
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }

    public List<ProjectDTO> findProjectList() {

        List<Project> projectList = projectRepo.findByProgressStatusGreaterThanEqual(PROJECT_LIST_STATUS);

        return parsingfindProject(projectList);
    }

    private List<ProjectDTO> parsingfindProject(List<Project> projectList) {

        return projectList.stream().map(project -> mapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
    }
}

