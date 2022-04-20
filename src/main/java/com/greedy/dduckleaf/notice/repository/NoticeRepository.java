package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
