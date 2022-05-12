package com.greedy.dduckleaf.main.repository;

import com.greedy.dduckleaf.main.entity.ProjectAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectAttachmentForMainRepository extends JpaRepository<ProjectAttachment, Integer> {

    List<ProjectAttachment> findByProjectProjectNo(int projectNo);
}
