package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberId(String memberId);
}
