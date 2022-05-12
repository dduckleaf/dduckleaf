package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : MemberForFundingRegistRepository
 * Comment : 펀딩 조회
 *
 * History
 * 2022-04-24 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface MemberForFundingRegistRepository extends JpaRepository<Member, Integer> {


    Member findByMemberId(String memberId);
}
