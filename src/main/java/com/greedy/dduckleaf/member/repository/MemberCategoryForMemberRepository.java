package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.MemberCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Interface : MemberCategoryForMemberRepository
 * Comment : 멤버 역할
 * History
 * 2022/05/12 (박상범) 처음 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface MemberCategoryForMemberRepository extends JpaRepository<MemberCategory, Integer> {

}
