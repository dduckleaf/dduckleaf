package com.greedy.dduckleaf.member.repository;

import com.greedy.dduckleaf.member.entity.PermitByUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Interface : PermitByUrlForMemberRepository
 * Comment : 역할별 접근가능 URL
 * History
 * 2022/05/12 (박상범) 처음 작성 / 역할 번호로 접근가능 ULR 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Repository
public interface PermitByUrlForMemberRepository extends JpaRepository<PermitByUrl, Integer> {

    List<PermitByUrl> findByMemberRole(int memberRole);
}
