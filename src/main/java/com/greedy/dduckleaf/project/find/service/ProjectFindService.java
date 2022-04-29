package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.dto.ProjectRewardCategoryDTO;
import com.greedy.dduckleaf.project.find.dto.SearchDTO;
import com.greedy.dduckleaf.project.find.entity.Project;
import com.greedy.dduckleaf.project.find.entity.ProjectBasicInfo;
import com.greedy.dduckleaf.project.find.repository.ProjectForProjectListRepository;
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

    static final int PAGE_SIZE = 12;
    private final static int PROJECT_LIST_STATUS = 2;
    private final ProjectForProjectListRepository projectRepo;
    private final ModelMapper mapper;

    @Autowired
    public ProjectFindService(ProjectForProjectListRepository projectRepo, ModelMapper mapper) {
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }

    public Page<ProjectDTO> findProjectLists(SearchDTO searchDTO, Pageable pageable) {

        String searchValue = searchDTO.getSearchValue();

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("projectNo").descending());

        if(searchValue != null) {
            Page<Project> pl = projectRepo.findByProjectExamineStatusIsNotNullAndProjectNameContaining(searchValue, pageable);
            System.out.println("pl = ");
            pl.forEach(System.out::println);
            Page<ProjectDTO> pdl = pl.map(project -> mapper.map(project, ProjectDTO.class));
            System.out.println("pdl = ");
            pdl.forEach(System.out::println);
            return pdl;
        }

        Page<ProjectDTO> projectList = projectRepo.findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNo(searchDTO.getProgressStatus(), pageable)
                .map(project -> {
                    System.out.println("project at service method 2 = " + project);

                    ProjectDTO projectDTO = mapper.map(project, ProjectDTO.class);
                    List<ProjectBasicInfo> infoList = project.getBasicInfo();
                    infoList.forEach(info -> {
                            projectDTO.setReward(mapper.map(info.getCategory(), ProjectRewardCategoryDTO.class));
                    });

                    return projectDTO;
                });
        projectList.forEach(System.out::println);

        return projectList;
    }
}