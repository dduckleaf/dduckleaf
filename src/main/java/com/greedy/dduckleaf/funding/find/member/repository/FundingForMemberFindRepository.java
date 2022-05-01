package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.Funding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : FundingForMemberFindRepository
 * Comment : Funding엔티티의 레파지토리
 *
 * History
 * 2022-04-25 (홍성원) 처음 작성 /
 * </pre>
 * @version 1.0.0
 * @author 홍성원
 */
public interface FundingForMemberFindRepository extends JpaRepository<Funding, Integer> {

    /* 회원번호로 펀딩목록을 조회홥니다. */
    Page<Funding> findByMemberNo(int memberNo, Pageable pageable);
}
