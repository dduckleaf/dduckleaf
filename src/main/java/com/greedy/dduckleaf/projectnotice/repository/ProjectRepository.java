package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.FarmerInfo;
import com.greedy.dduckleaf.projectnotice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {



}
