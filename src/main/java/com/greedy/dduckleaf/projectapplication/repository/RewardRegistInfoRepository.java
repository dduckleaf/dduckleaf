package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.RewardRegistInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRegistInfoRepository extends JpaRepository<RewardRegistInfo, Integer> {


    RewardRegistInfo findByProjectNo(int projectNo);
}
