package com.greedy.dduckleaf.project.find.repository;

import com.greedy.dduckleaf.project.find.entity.Project;
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

    List<Project> findByProgressStatusGreaterThanEqual(int i);
}
