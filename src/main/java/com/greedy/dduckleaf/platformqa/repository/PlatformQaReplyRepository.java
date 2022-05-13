package com.greedy.dduckleaf.platformqa.repository;

import com.greedy.dduckleaf.platformqa.entity.PlatformQaReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <pre>
 * Interface : PlatformQaReplyRepository
 * Comment : 1:1 문의
 * History
 * 2022-05-03 (차화응) 처음 작성 / 1:1문의 답변 목록조회 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
public interface PlatformQaReplyRepository extends JpaRepository<PlatformQaReply, Integer> {

    @Query(value = "SELECT A.PLATFORM_QA_REPLY_NO, A.PLATFORM_QA_REPLY_CONTENT, A.PLATFORM_QA_REPLY_REGIST_DATE, A.PLATFORM_QA_REPLY_STATUS, A.PLATFORM_QA_NO, A.ADMIN_NO FROM TBL_PLATFORM_QA_REPLY A ORDER BY A.PLATFORM_QA_REPLY_NO DESC",
            nativeQuery = true)
    List<PlatformQaReply> findAllPlatformQaReply();
}
