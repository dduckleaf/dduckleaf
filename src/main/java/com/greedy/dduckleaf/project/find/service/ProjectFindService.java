package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.repository.ProjectForProjectListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    static final int PAGE_SIZE = 5;
    private final static int PROJECT_LIST_STATUS = 2;
    private final ProjectForProjectListRepository projectRepo;
    private final ModelMapper mapper;

    @Autowired
    public ProjectFindService(ProjectForProjectListRepository projectRepo, ModelMapper mapper) {
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }

    public Page<ProjectDTO> findProjectLists(String searchValue, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("projectNo").descending());

        return projectRepo.findByProjectExamineStatusIsNotNullAndProjectNameContaining(searchValue, pageable).map(project -> mapper.map(project, ProjectDTO.class));
    }
}