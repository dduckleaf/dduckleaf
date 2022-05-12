package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : FundingInfoForMemberRepository
 * Comment : 펀딩내역
 * History
 * 2022/05/04 (박상범) 처음 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface FundingInfoForMemberRepository extends JpaRepository<FundingInfo, Integer> {

    List<FundingInfo> findByProject_projectProgressStatus_projectProgressStatusNameAndProject_projectStatusAndMember_memberNo(String projectProgressStatusName, String projectStatus, int memberNo);
}
