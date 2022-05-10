package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : MemberRepository
 * Comment : 회원관리
 * History
 * 2022/04/18 (박상범) 처음 작성 / 로그인 관련 findMemberByMemberId 작성
 * 2022/04/19 (박상범) 이메일 중복 확인 관련 findMemberByEmail 작성
 * 2022/04/22 (박상범) 휴대폰 번호 중복 확인 관련 findMemberByPhone 작성
 * 2022/04/23 (박상범) findMemberByEmail 수정, findMemberByPhone 수정
 * 2022/04/24 (박상범) 비밀번호 찾기 관련 findMember 작성
 * 2022/05/10 (박상범) 탈퇴 하지않은 회원 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.6
 * @author 박상범
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberId(String memberId);

    Member findMemberByEmail(String email);

    Member findMemberByPhone(String phone);

    @Query("select m from Member m where m.memberId = :memberId and m.email = :email")
    Member findMember(@Param("memberId") String memberId, @Param("email") String email);

    Member findMemberByMemberNo(int memberNo);

    Member findByMemberIdAndWithdrawalStatus(String memberId, String withdrawalStatus);
}
