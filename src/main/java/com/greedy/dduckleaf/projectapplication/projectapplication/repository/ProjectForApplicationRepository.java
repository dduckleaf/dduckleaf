package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Interface : ProjectForApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성
 * 2022/04/27 (박휘림) findByFarmerNoAndAndProgressStatus 메소드 작성
 * </pre>
 * @version 1.0.2
 * @author 박휘림
 */
public interface ProjectForApplicationRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT * FROM TBL_PROJECT P WHERE P.FARMER_NO = :farmerNo AND P.PROGRESS_STATUS = :i ORDER BY P.PROJECT_NO DESC LIMIT 1", nativeQuery = true)
    Project findByFarmerNoAndAndProgressStatus(int farmerNo, int i);

    @Query(value = "SELECT * FROM TBL_PROJECT P  WHERE P.PROJECT_NO =:projectNo", nativeQuery = true)
    Project findByProjectNo(int projectNo);
}
