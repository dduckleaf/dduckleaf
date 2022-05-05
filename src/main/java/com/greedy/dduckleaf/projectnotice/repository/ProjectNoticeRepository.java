package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <pre>
 * interface: ProjectNoticeRepository
 * Comment : 프로젝트 공지사항
 * History
 * 2022/04/18 (박휘림) 처음 작성
 * 2022/04/21 (박휘림) 목록 조회 메소드 작성 완료
 * 2022/04/24 (박휘림) 목록 조회 메소드 수정
 * </pre>
 * @version 1.0.2
 * @author 박휘림
 */
public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Integer> {

    Page<ProjectNotice> findAllByProjectNoticeStatusAndProjectNo(String y, int projectNo, Pageable pageable);

}
