package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.MemberForAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : MemberForFundingFindRepository
 * Comment : 회원정보 엔티티의 쿼리문을 수행하는 레파지토리
 *
 * History
 * 2022-04-25 (홍성원) 처음 작성 /
 * </pre>
 * @version 1.0.0
 * @author 홍성원
 */
public interface MemberForFundingFindRepository extends JpaRepository<MemberForAdmin, Integer> {

}
