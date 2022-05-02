package com.greedy.dduckleaf.platformqa.repository;

import com.greedy.dduckleaf.platformqa.entity.PlatformQaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatformQaCategoryRepository extends JpaRepository<PlatformQaCategory, Integer> {

    @Query(value = "SELECT A.PLATFORM_QA_CATEGORY_NO, A.PLATFORM_QA_CATEGORY_NAME FROM TBL_PLATFORM_QA_CATEGORY A ORDER BY A.PLATFORM_QA_CATEGORY_NO ASC",
            nativeQuery = true)

    List<PlatformQaCategory> findAllPlatformQaCategory();
}
