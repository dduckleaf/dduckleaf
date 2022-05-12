package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.shippingmanagement.entity.RewardShipping;
import com.greedy.dduckleaf.shippingmanagement.entity.RewardShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardShippingForShippingRepository extends JpaRepository<RewardShipping, Integer> {

    List<RewardShipping> findByProjectProjectNo(int projectNo);
}
