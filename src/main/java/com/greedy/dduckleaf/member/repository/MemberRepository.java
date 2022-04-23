package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : MemberRepository
 * Comment : 회원관리
 * History
 * 2022/04/18 (박상범) 처음 작성 / 로그인 관련 findMemberByMemberId 작성
 * 2022/04/19 (박상범) 이메일 중복 확인 관련 findMemberByEmail 작성
 * </pre>
 * @version 1.0.2
 * @author 박상범
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberId(String memberId);

    List<Member> findMemberByEmail(String email);
}
