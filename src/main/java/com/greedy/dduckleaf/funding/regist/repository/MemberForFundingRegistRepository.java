package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.regist.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberForFundingRegistRepository extends JpaRepository<Member, Integer> {


    Member findByMemberId(String memberId);
}
