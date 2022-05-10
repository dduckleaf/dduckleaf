package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Class : FundingRepository
 * Comment :
 *
 * History
 * 2022-04-24 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
public interface FundingRepository extends JpaRepository<Funding, Integer> {
    @Query(value = "SELECT * FROM TBL_FUNDING_INFO A ORDER BY A.FUNDING_INFO_NO DESC LIMIT 1", nativeQuery = true)
    Funding findLastest();

}
