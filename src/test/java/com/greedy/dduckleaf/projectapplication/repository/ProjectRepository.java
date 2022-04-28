package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : ProjectRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface ProjectRepository  extends JpaRepository<Project, Integer> {
}
