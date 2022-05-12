package com.greedy.dduckleaf.refund.regist.repository;

import com.greedy.dduckleaf.refund.regist.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectForRefundingRegistRepository
 * Comment : 환불 등록
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ProjectForRefundingRegistRepository extends JpaRepository<Project, Integer> {
}