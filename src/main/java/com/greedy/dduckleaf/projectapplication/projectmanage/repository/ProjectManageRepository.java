package com.greedy.dduckleaf.projectapplication.projectmanage.repository;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ProjectManageRepository
 * Comment : 관리자 페이지의 프로젝트 관리 업무
 *
 * findAllByProjectExamineStatus
 * 2022-05-05 (박휘림) 처음 작성 / findScheduledProjectList 메소드 작성
 * </pre>
 *
 * @author 박휘림
 * @version 1.0.0
 */
public interface ProjectManageRepository extends JpaRepository<Project, Integer> {


    Page<Project> findAllByProjectExamineStatusAndProgressStatus(Pageable pageable, String 승인, int i);

    List<Project> findAllByOpenDate(String openDate);

    Page<Project> findAllByProgressStatus(Pageable pageable, int i);
}
