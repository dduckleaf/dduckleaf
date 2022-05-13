package com.greedy.dduckleaf.projectapplication.projectmanage.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectApplicationInfoForManageRepository extends JpaRepository<ProjectApplicationInfo, Integer> {

    ProjectApplicationInfo findByProject_ProjectNo(int projectNo);

    List<ProjectApplicationInfo> findAllByProjectOpenDateAndProjectProgressStatus(String openDate, int i);

    List<ProjectApplicationInfo> findAllByProject_EndDateAndProjectProgressStatus(String endDate, int i);
}
