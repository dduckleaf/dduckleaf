package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.Project;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.JoinColumn;
import java.util.List;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {

//    @Query(value = "SELECT A.PROJECT_NOTICE_TITLE FROM TBL_PROJECT_NOTICE A", nativeQuery = true)
//    List<ProjectNotice> findProjectNotice();
//    List<ProjectNotice> findAll();
//    List<ProjectNotice> findAllNoticeList();
}
