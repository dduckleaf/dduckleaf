package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Member000Repository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT Z.PROJECT_REPORT_NO, Z.PROJECT_REPORT_DATE, C.REPORT_CATEGORY_NAME, Z.PROJECT_REPORT_STATUS, B.PROJECT_NAME " +
            "FROM TBL_member A " +
            "join TBL_PROJECT_REPORT Z on (A.MEMBER_NO = Z.MEMBER_NO)" +
            "JOIN TBL_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO) " +
            "JOIN TBL_REPORT_CATEGORY C ON (A.PROJECT_REPORT_CATEGORY_NO = C.REPORT_CATEGORY_NO) " +
            "WHERE A.MEMBER_NO = :memberNo " +
            "ORDER BY Z.PROJECT_REPORT_NO DESC",
            nativeQuery = true)
    List<Member> find(int member);

}
