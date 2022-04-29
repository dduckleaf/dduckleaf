package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.Notice;
import com.greedy.dduckleaf.notice.entity.NoticeForList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeForListRepository extends JpaRepository<NoticeForList, Integer> {
    Page<Notice> findAllByNoticeStatus(Pageable pageable, String y);
}
