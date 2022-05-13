package com.greedy.dduckleaf.followingproject.repository;

import com.greedy.dduckleaf.followingproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class: ProjectForFollowingProjectRepository
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 목록 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface ProjectForFollowingProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT\n " +
            "              A.*\n " +
            "         FROM TBL_PROJECT A\n " +
            "         JOIN TBL_FOLLOWING_PROJECT B ON (A.PROJECT_NO = B.PROJECT_NO)\n " +
            "         JOIN TBL_PROJECT_PROGRESS_STATUS C ON (A.PROGRESS_STATUS = C.PROJECT_PROGRESS_STATUS_NO)\n " +
            "         WHERE c.PROJECT_PROGRESS_STATUS_NAME = '진행중'\n " +
            "          AND B.MEMBER_NO = ? ",
            nativeQuery = true)
    List<Project> findFollowingProjectList(int memberNo);
}
