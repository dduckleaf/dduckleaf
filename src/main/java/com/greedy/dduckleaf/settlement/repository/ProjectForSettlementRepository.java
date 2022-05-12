package com.greedy.dduckleaf.settlement.repository;

import com.greedy.dduckleaf.settlement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectForSettlementRepositoryTests
 * Comment :
 *
 * History
 * 2022-04-30 (장민주) 처음 작성
 * 2022-05-01 (장민주) findAllByProgressStatusAndAchievementRateGreaterThan 쿼리 메소드 작성
 * 2022-05-01 (장민주) findByProjectNo 쿼리 메소드 작성
 * 2022-05-11 (장민주) findAllByProgressStatusAndAchievementRateGreaterThan ->
 *                    findByProjectStatusAndProgressStatusAndAchievementRateGreaterThanEqual 쿼리 메소드 수정
 * </pre>
 *
 * @author 장민주
 * @version 1.0.2
 */
public interface ProjectForSettlementRepository extends JpaRepository<Project, Integer> {

    /**
     * findAllByProgressStatusAndAchievementRateGreaterThan: 종료된 프로젝트 중 달성률이 100% 이상인 프로젝트 조회를 요청하는 메소드입니다.
     * @param projectStatus 프로젝트 승인 여부
     * @param progressStatus 프로젝트 진행 상태
     * @param achievementRate 프로젝트 달성률
     * @return 달성률 100%인 종료된 프로젝트 목록
     * @author 장민주
     */
    Page<Project> findByProjectStatusAndProgressStatusAndAchievementRateGreaterThanEqual(String projectStatus, int progressStatus, int achievementRate, Pageable pageable);

    /**
     * findByProjectNo: 프로젝트번호로 프로젝트조회를 요청하는 메소드입니다.
     * @param projectNo 프로젝트번호
     * @return 프로젝트 상세정보
     * @author 장민주
     */
    Project findByProjectNo(int projectNo);
}
