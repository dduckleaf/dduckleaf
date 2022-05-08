package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.MemberWithdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberWithdrawForMemberRepository extends JpaRepository<MemberWithdraw, Integer> {

}
