package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.FarmerInfo;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {



}
