package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectRepository
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

//    Project findByProjectNoAndProgressStatus(int projectNo, int i);
}
