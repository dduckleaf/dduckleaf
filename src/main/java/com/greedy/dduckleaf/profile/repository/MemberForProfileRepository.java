package com.greedy.dduckleaf.profile.repository;

import com.greedy.dduckleaf.profile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Interface : MemberForProfileRepository
 * Comment : 프로필
 * History
 * 2022/04/29 (박상범) 처음 작성 / 해당 이메일은 가진 회원 조회 관련 메소드 작성, 해당 휴대전화 번호르 가진 회원 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
@Repository
public interface MemberForProfileRepository extends JpaRepository<Member, Integer> {

    Member findMemberByEmail(String email);

    Member findMemberByPhone(String phone);
}
