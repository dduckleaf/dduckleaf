package com.greedy.dduckleaf.project.repository;

import com.greedy.dduckleaf.project.entity.ProjectAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProjectAttachmentForProjectDetailRepository extends JpaRepository<ProjectAttachment, Integer> {

    List<ProjectAttachment> findAllByProject_ProjectNo(int projectNo);
}
