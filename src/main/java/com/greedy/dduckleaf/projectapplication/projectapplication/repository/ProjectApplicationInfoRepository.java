package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.ProjectApplicationInfo;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : ProjectApplicationInfoRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/05/02 (박휘림) 처음 작성 / findAllByProjectApplicationCategoryOrProjectApplicationCategory 메소드 작성
 * 2022/05/03 (박휘림) findByProjectNo 메소드 작성
 * 2022/05/04 (박휘림) findByProjectApplicationNo 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
public interface ProjectApplicationInfoRepository extends JpaRepository<ProjectApplicationInfo, Integer> {

    Page<ProjectApplicationInfo> findAllByProjectApplicationCategoryOrProjectApplicationCategory(Pageable pageable, String 심사중, String 심사대기중);

    @Query(value = "SELECT * FROM TBL_PROJECT_APPLICATION_INFO A WHERE A.PROJECT_NO = :projectNo", nativeQuery = true)
    ProjectApplicationInfo findByProjectNo(int projectNo);

    ProjectApplicationInfo findByProjectApplicationNo(int projectApplicationNo);

}
