package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.MemberWithdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Interface : MemberWithdrawForMemberRepository
 * Comment : 탈퇴내역
 * History
 * 2022/05/04 (박상범) 처음 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface MemberWithdrawForMemberRepository extends JpaRepository<MemberWithdraw, Integer> {

}
