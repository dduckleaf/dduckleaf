package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.shippingmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectForShippingRepository extends JpaRepository<Project, Integer> {

    List<Project> findProjectNoByFarmerMemberNo(int memberNo);
}
