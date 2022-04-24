package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.NoticeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeCategoryRepository extends JpaRepository<NoticeCategory, Integer> {

    @Query(value = "SELECT A.NOTICE_CATEGORY_NO, A.NOTICE_CATEGORY_NAME FROM TBL_NOTICE_CATEGORY A ORDER BY A.NOTICE_CATEGORY_NO ASC",
            nativeQuery = true)
    List<NoticeCategory> findAllNoticeCategory();
}
