package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {

<<<<<<< HEAD
    Page<ProjectNotice> findAllByProjectNo(int projectNo, Pageable pageable);
=======
//    @Query(value = "SELECT A.PROJECT_NOTICE_TITLE FROM TBL_PROJECT_NOTICE A", nativeQuery = true)
//    List<ProjectNotice> findProjectNotice();
//    List<ProjectNotice> findAll();
//    List<ProjectNotice> findAllNoticeList();

>>>>>>> 1e101362e7c22ff1649529fcd9be5a852352e32f
}
