package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : PolicyForProjectReportRepository
 * Comment : Policy 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-05-03 (장민주) 처음 작성 / findPolicyNo 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface PolicyForProjectReportRepository extends JpaRepository<Policy, Integer> {

    @Query(value = "SELECT A.POLICY_NO\n" +
            "  FROM TBL_POLICY A\n" +
            " WHERE A.POLICY_NAME = :policyName",
            nativeQuery = true)
    int findPolicyNo(String policyName);
}
