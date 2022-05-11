package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.MemberForAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberForFundingFindRepository extends JpaRepository<MemberForAdmin, Integer> {

}
