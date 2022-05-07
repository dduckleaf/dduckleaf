package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundingInfoForMemberRepository extends JpaRepository<FundingInfo, Integer> {

}
