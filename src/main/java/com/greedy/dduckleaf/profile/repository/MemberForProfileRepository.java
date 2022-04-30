package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.profile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberForProfileRepository extends JpaRepository<Member, Integer> {


}
