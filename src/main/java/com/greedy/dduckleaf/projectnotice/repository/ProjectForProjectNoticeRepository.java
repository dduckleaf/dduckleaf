package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class: ProjectRepository
 * Comment : 프로젝트 공지사항
 * History
 * 2022/04/24 (박휘림) 회원 번호로 진행 중인 프로젝트 번호 조회 메소드 작성
 * 2022/05/11 (박휘림) 프로젝트 번호로 프로젝트 정보 조회 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface ProjectForProjectNoticeRepository extends JpaRepository<Project, Integer> {

    Project findByFarmerNoAndAndProgressStatus(int farmerNo, int i);

    Project findByProjectNo(int projectNo);
}
