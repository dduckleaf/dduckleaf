package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.dto.FundingInfoDTO;
import com.greedy.dduckleaf.project.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;

public interface FundingInfoForProjectDetailRepository extends JpaRepository<FundingInfo, Integer> {

    List<FundingInfo> findAllByProjectNo(int projectNo);
}
