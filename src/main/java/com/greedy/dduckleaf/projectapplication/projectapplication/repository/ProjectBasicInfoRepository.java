package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.entity.ProjectBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : ProjectBasicInfoRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/28 (박휘림) 처음 작성 / findByProjectNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface ProjectBasicInfoRepository extends JpaRepository<ProjectBasicInfo, Integer> {

    ProjectBasicInfo findByProjectNo(int projectNo);
}
