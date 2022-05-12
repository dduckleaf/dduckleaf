package com.greedy.dduckleaf.refund.find.repository;

import com.greedy.dduckleaf.refund.find.entity.ProjectForAdminList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : ProjectForAdminRefundFindRepositroy
 * Comment : 환불 조회
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ProjectForAdminRefundFindRepositroy extends JpaRepository<ProjectForAdminList, Integer> {

    Page<ProjectForAdminList> findByProgressStatus_progressNoBetween(int i, int i1, Pageable pageable);
}
