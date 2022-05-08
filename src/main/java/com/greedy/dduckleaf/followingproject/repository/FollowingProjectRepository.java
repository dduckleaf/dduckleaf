package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class: FollowingProjectRepository
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface FollowingProjectRepository extends JpaRepository<FollowingProject, Integer> {

    FollowingProject findByProjectProjectNoAndMemberNo(int projectNo, int memberNo);
}
