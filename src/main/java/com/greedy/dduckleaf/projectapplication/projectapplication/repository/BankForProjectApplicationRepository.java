package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : BankForProjectApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/05/01 (박휘림) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
public interface BankForProjectApplicationRepository extends JpaRepository<Bank, Integer> {
}
