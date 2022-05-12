package com.greedy.dduckleaf.platformqa.repository;

import com.greedy.dduckleaf.platformqa.entity.PlatformQaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : PlatformQaCategoryRepository
 * Comment : 1:1 문의
 * History
 * 2022-05-02 (차화응) 처음 작성 / 1:1문의 유형 목록조회 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
public interface PlatformQaCategoryRepository extends JpaRepository<PlatformQaCategory, Integer> {

    @Query(value = "SELECT A.PLATFORM_QA_CATEGORY_NO, A.PLATFORM_QA_CATEGORY_NAME FROM TBL_PLATFORM_QA_CATEGORY A ORDER BY A.PLATFORM_QA_CATEGORY_NO ASC",
            nativeQuery = true)
    List<PlatformQaCategory> findAllPlatformQaCategory();
}
