package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

//    List<Notice> findByTitleContaining(String keyword);

    List<Notice> findByNoticeNameContaining(String noticeName);
}