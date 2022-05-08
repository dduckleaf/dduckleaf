package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectForMemberRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProjectProgressStatus_projectProgressStatusNameInAndProjectStatusAndFarmer_memberNo(List<String> projectProgressNameList, String projectStatus, int memberNo);
}
