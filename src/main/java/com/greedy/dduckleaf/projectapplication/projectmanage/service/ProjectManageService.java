package com.greedy.dduckleaf.projectapplication.projectmanage.service;

import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.projectmanage.repository.ProjectManageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : ProjectManagerService
 * Comment : 프로젝트 관리
 * History
 * 2022-05-05 (박휘림) 처음작성 / findScheduledProjectList 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
@Service
public class ProjectManageService {

    @Autowired
    private final ProjectManageRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectManageService(ProjectManageRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findScheduledProjectList: 오픈예정 프로젝트 목록을 조회합니다.
     * @param pageable: 페이징 정보를 담은 객체
     * @return 오픈 예정 프로젝트 목록
     * @author 박휘림
     */
    public Page<ProjectDTO> findScheduledProjectList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNo").descending());

        return projectRepository.findAllByProjectExamineStatus(pageable, "승인").map(project -> modelMapper.map(project, ProjectDTO.class));
    }
}
