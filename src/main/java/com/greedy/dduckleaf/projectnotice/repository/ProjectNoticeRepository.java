package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {

//    @Query(value = "SELECT A.PROJECT_NOTICE_TITLE FROM TBL_PROJECT_NOTICE A", nativeQuery = true)
//    List<ProjectNotice> findProjectNotice();
//    List<ProjectNotice> findAll();
//    List<ProjectNotice> findAllNoticeList();

}
