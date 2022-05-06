package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.SettlementInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : SettlementInfoForSettlementCalculateRepository
 * Comment : SettlementInfo 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-06 (장민주) 처음 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface SettlementInfoForSettlementCalculateRepository extends JpaRepository<SettlementInfo, Integer> {

    /**
     * findByProject_ProjectNo: 프로젝트번호로 정산정보 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 정산정보
     * @author 장민주
     */
    SettlementInfo findByProject_ProjectNo(int projectNo);
}
