package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.entity.ProjectApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * <pre>
 * Class : ProjectApplicationInfoForProjectDetailRepository
 * Comment : 프로젝트
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
public interface ProjectApplicationInfoForProjectDetailRepository extends JpaRepository<ProjectApplicationInfo, Integer> {


    ProjectApplicationInfo findByProject_ProjectNo(int projectNo);
}
