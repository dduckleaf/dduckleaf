package com.greedy.dduckleaf.project.find.repository;

import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ProjectForProjectListRepository
 * Comment :
 *
 * History
 * 2022-04-27 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ProjectForProjectListRepository extends JpaRepository<Project, Integer> {

    Page<Project> findByProjectExamineStatusIsNotNullAndProjectNameContaining(String searchValue, Pageable pageable);

    Page<Project> findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNo(int progressStatus,Pageable pageable);

    Page<Project> findByProjectExamineStatusIsNotNullAndProgressStatus_projectProgressStuatusNoAndBasicInfo_category_projectCategoryNo(int progressStatus,int rewardCategoryNo, Pageable pageable);

    Page<Project> findByProgressStatus_projectProgressStuatusNo(int progressStatus, Pageable pageable);
}
