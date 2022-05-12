package com.greedy.dduckleaf.refund.regist.repository;

import com.greedy.dduckleaf.refund.regist.entity.Refunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : RefundingForRegistRepository
 * Comment : 환불 등록
 *
 * History
 * 2022-05-03 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface RefundingForRegistRepository extends JpaRepository<Refunding, Integer> {

    @Query(value = "SELECT * FROM TBL_REFUNDING A ORDER BY A.REFUNDING_INFO_NO DESC LIMIT 1", nativeQuery = true)
    Refunding findLatest();
}