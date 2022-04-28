package com.greedy.dduckleaf.myfunding.repository;

import com.greedy.dduckleaf.myfunding.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : FundingInfoForMyFundingRepository
 * Comment : 마이펀딩
 * History
 * 2022/04/28 (박상범) 처음 작성 / 펀딩 횟수 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface FundingInfoForMyFundingRepository extends JpaRepository<FundingInfo, Integer> {

    @Query(value = "SELECT " +
            "              A.FUNDING_INFO_NO, " +
            "              A.MEMBER_NO, " +
            "              A.PROJECT_NO " +
            "         FROM TBL_FUNDING_INFO A " +
            "         JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO) " +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS C ON (B.PROGRESS_STATUS = C.PROJECT_PROGRESS_STATUS_NO) " +
            "        WHERE C.PROJECT_PROGRESS_STATUS_NAME = '진행중' " +
            "          AND A.MEMBER_NO = ? ",
            nativeQuery = true)
    List<FundingInfo> findFundingByMemberNoAndProjectProgressStatus(int memberNo);
}
