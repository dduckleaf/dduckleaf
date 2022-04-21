package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberForProjectReportRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberNo(int memberNo);
}
