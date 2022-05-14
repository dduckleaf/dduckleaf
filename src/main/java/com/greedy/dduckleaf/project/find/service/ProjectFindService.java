package com.greedy.dduckleaf.project.find.service;

import com.greedy.dduckleaf.project.finalfield.CodeForProject;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.dto.ProjectRewardCategoryDTO;
import com.greedy.dduckleaf.project.find.dto.SearchDTO;
import com.greedy.dduckleaf.project.find.entity.Project;
import com.greedy.dduckleaf.project.find.repository.ProjectForProjectListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;

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
public class ProjectFindService implements CodeForProject {


    /* 의존성주입 받을 빈을 final로 선언 후 생성자주입을 받습니다. */
    private final ProjectForProjectListRepository projectRepo;
    private final ModelMapper mapper;

    @Autowired
    public ProjectFindService(ProjectForProjectListRepository projectRepo, ModelMapper mapper) {
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }



    /**
     * findProjectLists : 프로젝트 목록을 조회 후 반환합니다.
     * @param searchDTO : 조회에 필요한 정보가 담긴 DTO를 전달받습니다.
     * @param pageable : 페이징 정보가 담긴 Pageable 인스턴스를 전달받습니다.
     * @return projects : 프로젝트 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<ProjectDTO> findProjectLists(SearchDTO searchDTO, Pageable pageable) {

        /* 검색어로 조회하는 경우와 필터로 조회하는 경우, 두 가지에 대해 다른 방법으로 조회합니다. */
        String searchValue = searchDTO.getSearchValue();

        /* 한 페이지에 출력될 정보를 설정해줍니다. */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("projectNo").descending());

        /* 1. 검색어가 null이 아닐경우 검색어로 프로젝트 목록을 조회합니다. */
        if(searchValue != null) {
            Page<Project> projects = projectRepo.findByProjectExamineStatusIsNotNullAndProjectNameContaining(searchValue, pageable);

            return parsingProjectList(projects);
        }

        /* 2. 필터로 조회하는경우 리워드 카테고리와 프로젝트 상태 코드로 프로젝트 목록을 조회합니다. */
        Page<Project> projects = projectRepo.findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNoAndBasicInfo_category_projectCategoryNo(searchDTO.getProgressStatus(), searchDTO.getRewardCategory(), pageable);

        return parsingProjectList(projects);
    }



    /**
     * parsingProjectList : 프로젝트리스트에 대해, 각각의 엔티티의 리워드 정보를 프로젝트DTO의 리워드 필드에 저장합니다.
     * @param projects : 페이징 정보를 담고있는 프로젝트 목록 정보를 전달받습니다.
     * @return projectList : 리워드 정보를 저장한 프로젝트DTO 자료형의 리스트를 반환합니다.
     *
     * @author 홍성원
     */
    /* Project엔티티의 리워드 카테고리 정보를 DTO의 리워드 필드에 저장합니다.  */
    private Page<ProjectDTO> parsingProjectList(Page<Project> projects) {

        Page<ProjectDTO> projectList = projects.map(project -> {
            ProjectDTO projectDTO = mapper.map(project, ProjectDTO.class);

            projectDTO.setReward(mapper.map(project.getBasicInfo().getCategory(), ProjectRewardCategoryDTO.class));

            projectDTO.setImagePath("/upload/original/" + project.getAttachments().get(0).getProjectAttachmentSaveName());
            parsingProjectTimeInfo(projectDTO);

            return projectDTO;
        });

        return projectList;
    }



    /**
     * parsingProjectTimeInfo : 프로젝트 상태별 시간정보를 저장합니다.
     * @param projectDTO : 프로젝트DTO를 전달받습니다.
     *
     * @author 홍성원
     */
    private void parsingProjectTimeInfo(ProjectDTO projectDTO) {

        /* 프로젝트 진행상태 번호를 저장합니다. */
        int progressStatus = projectDTO.getProgressStatus().getProjectProgressStuatusNo();
        String timeInfo = "";

        /* 진행상태별로 다르게 문구를 저장합니다. */
        switch (progressStatus) {
            case PROJECT_PROGRESS_STATUS_오픈예정: timeInfo = projectDTO.getOpenDate() + ""; break;
            /* 진행중일 경우 Dday를 계산 후 저장합니다. */
            case PROJECT_PROGRESS_STATUS_진행중: timeInfo = calculateDDay(projectDTO.getEndDate()); break;
            case PROJECT_PROGRESS_STATUS_종료: timeInfo = projectDTO.getEndDate() + " 종료됨";break;
        }

        projectDTO.setTimeInfo(timeInfo);
    }



    /**
     * calculateDDay : Dday를 계산 후 문구를 반환합니다.
     * @param endDate : 종료일을 전달받습니다.
     * @return timeInfo : ProjectDTO에 저장 할 문구를 반환합니다.
     *
     * @author 홍성원
     */
    private String calculateDDay(Date endDate) {

        /* Dday를 계산합니다. */
        String timeInfo = "";

        long calculate = endDate.getTime() - new Date(System.currentTimeMillis()).getTime();

        int Ddays = (int) (calculate / (24 * 60 * 60 * 1000));

        /* Dday와 화면에 출력할 문구 양식을 더한 후 반환합니다. */
        timeInfo = Ddays + "일 남음";

        return timeInfo;
    }

    public Page<ProjectDTO> findProjectListsByProgressingNo(int progressingNo, Pageable pageable) {

        /* 한 페이지에 출력될 정보를 설정해줍니다. */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("projectNo").descending());

        /* 프로젝트 상태 코드로 프로젝트 목록을 조회합니다. */
        Page<Project> projects = projectRepo.findByProgressStatus_projectProgressStuatusNo(progressingNo, pageable);

        return parsingProjectList(projects);
    }
}
































