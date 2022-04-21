package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {


    Page<ProjectNotice> findAllByProjectNo(int projectNo, Pageable pageable);

}
