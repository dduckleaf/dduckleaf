package com.greedy.dduckleaf.shippingmanagement.repository;

import com.greedy.dduckleaf.shippingmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : ShippingService
 * Comment : Project 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 * History
 * 2022/05/06 (조남기) 처음작성 / findProjectNoByFarmerMemberNo 서비스 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 조남기
 */
@Repository
public interface ProjectForShippingRepository extends JpaRepository<Project, Integer> {

    List<Project> findProjectNoByFarmerMemberNo(int memberNo);

    Project findProjectNoByProjectNo(int projectNo);
}
