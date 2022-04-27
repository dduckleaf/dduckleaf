package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectapplication.entity.ProjectBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectBasicInfoRepository extends JpaRepository<ProjectBasicInfo, Integer> {
}
