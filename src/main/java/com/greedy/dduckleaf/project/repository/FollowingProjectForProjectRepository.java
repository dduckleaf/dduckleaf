package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.entity.FollowingProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingProjectForProjectRepository extends JpaRepository<FollowingProject, Integer> {

    List<FollowingProject> findByMemberNoAndProjectNo(int memberNo, int projectNo);
}
