package com.greedy.dduckleaf.notice.repository;

import com.greedy.dduckleaf.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Interface : NoticeRepository
 * Comment : 공지사항
 * History
 * 2022/04/19 (차화응) 처음 작성
 * 2022/04/21 (차화응) 공지사항 조회수 갱신 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 차화응
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    /* 조회수 갱신 */
    @Modifying
    @Query("update Notice notice set notice.noticeCount = notice.noticeCount + 1 where notice.noticeNo = :noticeNo")
    int updateNoticeCount(int noticeNo);
}