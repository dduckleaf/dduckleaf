package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.refund.find.entity.ProjectForAdminList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectForAdminRefundFindRepositroy extends JpaRepository<ProjectForAdminList, Integer> {

    Page<ProjectForAdminList> findByProgressStatus_progressNoBetween(int i, int i1, Pageable pageable);
}
