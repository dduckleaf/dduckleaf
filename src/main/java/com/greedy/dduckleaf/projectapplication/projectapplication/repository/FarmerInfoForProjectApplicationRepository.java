package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.FarmerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : FarmerInfoForProjectApplicationRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성
 * 2022/04/30 (박휘림) findByFarmerNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface FarmerInfoForProjectApplicationRepository extends JpaRepository<FarmerInfo, Integer> {

    @Query(value = "SELECT * FROM TBL_FARMER_INFO A WHERE A.MEMBER_NO =:memberNo", nativeQuery = true)
    FarmerInfo findByFarmerNo(int memberNo);
}
