package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ReportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ReportCategoryRepository
 * Comment : ReportCategory 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-05-02 (장민주) 처음 작성 / findAll 메소드 작성.
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ReportCategoryRepository extends JpaRepository<ReportCategory, Integer> {

    List<ReportCategory> findAll();
}
