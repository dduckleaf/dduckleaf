package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.followingproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectForFollowingProjectRepository extends JpaRepository<Project, Integer> {

}
