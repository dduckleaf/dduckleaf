package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectReportRepository extends JpaRepository<ProjectReport, Integer> {

    List<ProjectReport> findByMemberNo(int memberNo);
}
