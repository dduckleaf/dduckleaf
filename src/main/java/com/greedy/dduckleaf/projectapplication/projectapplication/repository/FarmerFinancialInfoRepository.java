package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.FarmerFinancialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Interface : FarmerFinancialInfoRepository
 * Comment : 프로젝트 신청
 * HistoryEXAMINE_STATUS
 * 2022/04/25 (박휘림) 처음 작성
 * 2022/04/30 (박휘림) findByMemberNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface FarmerFinancialInfoRepository extends JpaRepository<FarmerFinancialInfo, Integer> {

    @Query(value = "SELECT * FROM TBL_FARMER_FINANCIAL_INFO A WHERE A.FARMER_NO = :memberNo ORDER BY A.FINANCIAL_INFO_NO DESC LIMIT 1", nativeQuery = true)
    FarmerFinancialInfo findByMemberNo(int memberNo);
}
