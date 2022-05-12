package com.greedy.dduckleaf.projectapplication.projectmanage.service;

import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.entity.ProjectApplicationInfo;
import com.greedy.dduckleaf.projectapplication.projectmanage.repository.ProjectApplicationInfoForManageRepository;
import com.greedy.dduckleaf.projectapplication.projectmanage.repository.ProjectManageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * <pre>
 * Class : ProjectManagerService
 * Comment : 프로젝트 관리
 * History
 * 2022-05-05 (박휘림) 처음작성 / findScheduledProjectList 메소드 작성
 * 2022-05-11 (박휘림) findProjectApplicationDetail, openProject 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
@Service
public class ProjectManageService {

    @Autowired
    private final ProjectManageRepository projectRepository;
    private final ProjectApplicationInfoForManageRepository projectApplicationInfoForManageRepository;
    private final ModelMapper modelMapper;

    public ProjectManageService(ProjectManageRepository projectRepository, ProjectApplicationInfoForManageRepository projectApplicationInfoForManageRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.projectApplicationInfoForManageRepository = projectApplicationInfoForManageRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findScheduledProjectList: 오픈예정 프로젝트 목록을 조회합니다.
     * @param pageable: 페이징 정보를 담은 객체
     * @return 오픈 예정 프로젝트 목록
     * @author 박휘림
     */
    public Page<ProjectDTO> findScheduledProjectList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNo").descending());

        return projectRepository.findAllByProjectExamineStatusAndProgressStatus(pageable, "승인", 2).map(project -> modelMapper.map(project, ProjectDTO.class));
    }

    /**
     * findProjectApplicationDetail: 오픈예정 프로젝트 상세내용을 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 오픈 예정 프로젝트 상세정보
     * @author 박휘림
     */
    public ProjectApplicationInfoDTO findProjectApplicationDetail(int projectNo) {

        ProjectApplicationInfo projectApplicationInfo = projectApplicationInfoForManageRepository.findByProject_ProjectNo(projectNo);

        return modelMapper.map(projectApplicationInfo, ProjectApplicationInfoDTO.class);
    }

    /**
     * openProject: 프로젝트 상태를 심사중에서 오픈예정으로 변경합니다.
     * @author 박휘림
     */
    @Transactional
    public void openProject() {

        String openDate = LocalDate.now().toString();

        List<ProjectApplicationInfo> projectList = projectApplicationInfoForManageRepository.findAllByProjectOpenDateAndProjectProgressStatus(openDate, 2);

        projectList.forEach(projectApplicationInfo -> projectApplicationInfo.getProject().setProgressStatus(3));
    }
}