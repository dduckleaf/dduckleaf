package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundingInfoForMemberRepository extends JpaRepository<FundingInfo, Integer> {

//    @Query(value = "SELECT " +
//            "              A.FUNDING_INFO_NO, " +
//            "              A.MEMBER_NO " +
////            "              A.PROJECT_NO " +
//            "         FROM TBL_FUNDING_INFO A " +
//            "         JOIN TBL_MEMBER B ON (A.MEMBER_NO = B.MEMBER_NO) " +
//            "         JOIN TBL_PROJECT C ON (A.PROJECT_NO = C.PROJECT_NO) " +
//            "         JOIN TBL_PROJECT_PROGRESS_STATUS D ON (C.PROGRESS_STATUS = D.PROJECT_PROGRESS_STATUS_NO) " +
//            "        WHERE D.PROJECT_PROGRESS_STATUS_NAME = '진행중' " +
//            "          AND C.PROJECT_STATUS = 'Y' " +
//            "          AND B.MEMBER_NO = ? ",
//            nativeQuery = true)
    List<FundingInfo> findByProject_projectProgressStatus_projectProgressStatusNameAndProject_projectStatusAndMember_memberNo(String projectProgressStatusName, String projectStatus, int memberNo);
}
