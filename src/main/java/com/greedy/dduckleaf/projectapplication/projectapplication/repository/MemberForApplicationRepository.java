package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberForApplicationRepository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT * FROM TBL_MEMBER A WHERE A.PHONE = :phone", nativeQuery = true)
    Member findMemberByPhone(String phone);
}
