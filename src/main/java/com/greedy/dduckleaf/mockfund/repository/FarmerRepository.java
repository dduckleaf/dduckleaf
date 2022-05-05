package com.greedy.dduckleaf.mockfund.repository;

import com.greedy.dduckleaf.mockfund.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

}
