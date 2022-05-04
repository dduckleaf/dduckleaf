package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.RefundPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : RefundPolicyForProjectApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성
 * 2022/04/30 (박휘림) findByProjectNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface RefundPolicyForProjectApplicationRepository extends JpaRepository<RefundPolicy, Integer> {

    RefundPolicy findByProjectNo(int projectNo);
}
