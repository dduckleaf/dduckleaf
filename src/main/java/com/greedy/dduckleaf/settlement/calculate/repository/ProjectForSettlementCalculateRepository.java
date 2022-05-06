package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectForSettlementCalculateRepository
 * Comment : Project 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-06 (장민주) 처음 작성 / findById 쿼리메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectForSettlementCalculateRepository extends JpaRepository<Project, Integer> {

    /**
     * findById: 프로젝트번호로 프로젝트 엔티티를 조회하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트
     * @author 장민주
     */
    Project findById(int projectNo);
}
