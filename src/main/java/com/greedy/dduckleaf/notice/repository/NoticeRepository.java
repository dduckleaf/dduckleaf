package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Interface : NoticeRepository
 * Comment : 공지사항
 * History
 * 2022/04/19 (차화응) 처음 작성 / 공지사항 목록조회 메소드 작성
 * 2022/04/20 (차화응) 공지사항 목록조회 검색 메소드 작성
 * 2022/04/21 (차화응) 공지사항 목록조회 검색 메소드 주석 처리
 * </pre>
 * @version 1.0.2
 * @author 차화응
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}