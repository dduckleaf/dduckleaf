package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectForApplicationRepository extends JpaRepository<Project, Integer> {

    com.greedy.dduckleaf.projectnotice.entity.Project findByFarmerNoAndAndProgressStatus(int farmerNo, int i);
}
