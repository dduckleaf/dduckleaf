package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.ProjectApplyFeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectApplyFeeInfoForSettlementCalculateRepository
 * Comment : ProjectApplyFeeInfo 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-05 (장민주) 처음 작성
 * 2022-05-05 (장민주) findByProjectNo 쿼리메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectApplyFeeInfoForSettlementCalculateRepository extends JpaRepository<ProjectApplyFeeInfo, Integer> {

    /**
     * findByProjectNo: 프로젝트에 적용된 수수료정책 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트에 적용된 수수료정책 정보
     * @author 장민주
     */
    ProjectApplyFeeInfo findByProjectNo(int projectNo);
}
