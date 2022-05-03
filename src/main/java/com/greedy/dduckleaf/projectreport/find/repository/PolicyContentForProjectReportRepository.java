package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.PolicyContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Class : PolicyContentForProjectReportRepository
 * Comment : PolicyContent 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-05-03 (장민주) 처음 작성 / findAllByPolicy_PolicyNo 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface PolicyContentForProjectReportRepository extends JpaRepository<PolicyContent, Integer> {

    List<PolicyContent> findAllByPolicy_PolicyNo(int policyNo);
}
