package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReportReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectReportReplyRepository extends JpaRepository<ProjectReportReply, Integer> {

    List<ProjectReportReply> findAll();
//    ProjectReportReply findByProjectReportNo(@Param("projectReportNo") int ProjectReportNo);
}
