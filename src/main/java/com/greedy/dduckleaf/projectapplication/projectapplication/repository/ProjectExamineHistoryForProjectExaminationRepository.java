package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectExamineHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : ProjectExamineHistoryForProjectExaminationRepository
 * Comment : 프로젝트 심사
 * History
 * 2022/05/05 (박휘림) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
public interface ProjectExamineHistoryForProjectExaminationRepository extends JpaRepository<ProjectExamineHistory, Integer> {

    ProjectExamineHistory findAllByProjectNo(int projectNo);
}
