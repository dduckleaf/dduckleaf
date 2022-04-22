package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
}
