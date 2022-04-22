package com.greedy.dduckleaf.projectreport.detail.repository;

import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReportReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectReportReplyRepository extends JpaRepository<ProjectReportReply, Integer> {

    List<ProjectReportReply> findAll();
//    ProjectReportReply findByProjectReportNo(@Param("projectReportNo") int ProjectReportNo);
}
