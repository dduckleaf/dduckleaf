package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : MemberForProjectReportRepository
 * Comment : Member 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-19 (장민주) 처음 작성 / findMemberByMemberNo 서비스메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface MemberForProjectReportRepository extends JpaRepository<Member, Integer> {

    /**
     * findMemberByMemberNo: 회원번호로 회원의 상세정보를 조회하는 메소드입니다.
     * @param memberNo
     * @return 회원 정보
     * @author 장민주
     */
    Member findMemberByMemberNo(int memberNo);
}
