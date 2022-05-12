package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.NoticeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : NoticeCategoryRepository
 * Comment : 공지사항 카테고리
 * History
 * 2022/04/23 (차화응) 처음 작성 / 공지사항 분류 목록조회 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 차화응
 */
public interface NoticeCategoryRepository extends JpaRepository<NoticeCategory, Integer> {

    @Query(value = "SELECT A.NOTICE_CATEGORY_NO, A.NOTICE_CATEGORY_NAME FROM TBL_NOTICE_CATEGORY A ORDER BY A.NOTICE_CATEGORY_NO ASC",
            nativeQuery = true)
    List<NoticeCategory> findAllNoticeCategory();
}
