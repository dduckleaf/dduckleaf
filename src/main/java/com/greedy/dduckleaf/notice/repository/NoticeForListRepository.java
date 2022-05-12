package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.NoticeForList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Interface : NoticeForListRepository
 * Comment : 공지사항 목록조회
 * History
 * 2022/04/19 (차화응) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
public interface NoticeForListRepository extends JpaRepository<NoticeForList, Integer> {
}
