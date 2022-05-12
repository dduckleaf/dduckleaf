package com.greedy.dduckleaf.settlement.repository;

import com.greedy.dduckleaf.settlement.entity.SettlementInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class : SettlementInfoRepository
 * Comment : SettlementInfo 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-30 (장민주) 처음 작성
 * 2022-04-30 (장민주) findByProject_ProjectNo 쿼리메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface SettlementInfoRepository extends JpaRepository<SettlementInfo, Integer> {

    /**
     * findByProject_ProjectNo: 프로젝트번호로 정산정보 조회를 요청하는 메소드입니다.
     * @param projectNo 프로젝트번호
     * @return 프로젝트 정산정보
     * @author 장민주
     */
    SettlementInfo findByProject_ProjectNo(int projectNo);

}
