package com.greedy.dduckleaf.settlement.repository;

import com.greedy.dduckleaf.settlement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ProjectForSettlementRepositoryTests
 * Comment :
 *
 * History
 * 2022-04-30 (장민주) 처음 작성
 * 2022-05-01 (장민주) findAllByProgressStatusAndAchievementRateGreaterThan 쿼리 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectForSettlementRepository extends JpaRepository<Project, Integer> {

    /**
     * findAllByProgressStatusAndAchievementRateGreaterThan: 종료된 프로젝트 중 달성률이 100% 이상인 프로젝트 조회를 요청하는 메소드입니다.
     * @param progressStatus: 프로젝트 진행 상태
     * @param achievementRate: 프로젝트 달성률
     * @return 달성률 100%인 종료된 프로젝트 목록
     * @author 장민주
     */
    Page<Project> findAllByProgressStatusAndAchievementRateGreaterThan(int progressStatus, int achievementRate, Pageable pageable);

    Project findByProjectNo(int projectNo);
}
