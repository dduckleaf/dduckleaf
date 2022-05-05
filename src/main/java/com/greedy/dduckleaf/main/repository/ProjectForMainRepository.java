package com.greedy.dduckleaf.main.repository;

import com.greedy.dduckleaf.main.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : ProjectForMainRepository
 * Comment : 실시간 랭킹, 떡잎추천
 * History
 * 2022-05-06 (박상범) 처음 작성 / 떡잎 추천 조회 관련 메소드 작성성 실시간 랭킹 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface ProjectForMainRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT " +
            "              A.PROJECT_NO, " +
            "              A.PROJECT_NAME, " +
            "              A.FUND_TARGET_AMOUNT, " +
            "              A.OPEN_DATE, " +
            "              A.END_DATE, " +
            "              A.PROJECT_STATUS, " +
            "              A.ACHIEVEMENT_RATE, " +
            "              A.EXAMINE_STATUS, " +
            "              A.PROJECT_EXAMINE_STATUS, " +
            "              A.PROGRESS_STATUS, " +
            "              A.MAX_TARGET_AMOUNT, " +
            "              A.FARMER_NO " +
            "         FROM TBL_PROJECT A " +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS B ON (A.PROGRESS_STATUS = B.PROJECT_PROGRESS_STATUS_NO) " +
            "        WHERE B.PROJECT_PROGRESS_STATUS_NAME = '진행중' " +
            "          AND A.PROJECT_STATUS = 'Y' " +
            "        LIMIT 6",
            nativeQuery = true)
    List<Project> findDduckleafRecommendList();

    @Query(value = "SELECT " +
            "              A.PROJECT_NO, " +
            "              A.PROJECT_NAME, " +
            "              A.FUND_TARGET_AMOUNT, " +
            "              A.OPEN_DATE, " +
            "              A.END_DATE, " +
            "              A.PROJECT_STATUS, " +
            "              A.ACHIEVEMENT_RATE, " +
            "              A.EXAMINE_STATUS, " +
            "              A.PROJECT_EXAMINE_STATUS, " +
            "              A.PROGRESS_STATUS, " +
            "              A.MAX_TARGET_AMOUNT, " +
            "              A.FARMER_NO " +
            "         FROM TBL_PROJECT A " +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS B ON (A.PROGRESS_STATUS = B.PROJECT_PROGRESS_STATUS_NO) " +
            "        WHERE B.PROJECT_PROGRESS_STATUS_NAME = '진행중' " +
            "          AND A.PROJECT_STATUS = 'Y' " +
            "        ORDER BY a.ACHIEVEMENT_RATE DESC " +
            "        LIMIT 5 ",
            nativeQuery = true)
    List<Project> findRankingList();
}
