package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectForProjectReportRepository
 * Comment : Project 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-27 (장민주) 처음 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectForProjectReportRepository extends JpaRepository<Project, Integer> {
}
