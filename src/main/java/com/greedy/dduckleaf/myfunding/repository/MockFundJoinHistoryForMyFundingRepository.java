package com.greedy.dduckleaf.myfunding.repository;

import com.greedy.dduckleaf.myfunding.entity.MockFundJoinHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : MockFundJoinHistoryForMyFundingRepository
 * Comment : 마이펀딩
 * History
 * 2022/04/28 (박상범) 처음 작성 / 모의 펀딩 횟수 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface MockFundJoinHistoryForMyFundingRepository extends JpaRepository<MockFundJoinHistory, Integer> {

    List<MockFundJoinHistory> findByMember_memberNo(int memberNo);
}
