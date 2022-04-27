package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.FarmerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerInfoForProjectApplicationRepository extends JpaRepository<FarmerInfo, Integer> {
}
