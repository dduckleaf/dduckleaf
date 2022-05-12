package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : ProjectForMemberRepository
 * Comment : 프로젝트
 * History
 * 2022/05/04 (박상범) 처음 작성 / 회원이 진행중인 프로젝트 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface ProjectForMemberRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProjectProgressStatus_projectProgressStatusNameInAndProjectStatusAndFarmer_memberNo(List<String> projectProgressNameList, String projectStatus, int memberNo);
}
