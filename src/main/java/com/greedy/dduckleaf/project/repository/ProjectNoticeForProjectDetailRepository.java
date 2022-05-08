package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.project.entity.ProjectNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectNoticeForProjectDetailRepository extends JpaRepository<ProjectNotice, Integer> {

    Page<ProjectNotice> findAllByProjectNoticeStatusAndProjectNo(String y, int projectNo, Pageable pageable);
}
