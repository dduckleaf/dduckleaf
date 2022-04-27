package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProjectShippingInfoRepository extends JpaRepository<ProjectShippingInfo, CriteriaBuilder.In> {
}
