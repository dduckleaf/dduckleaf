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
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface SettlementInfoRepository extends JpaRepository<SettlementInfo, Integer> {

    SettlementInfo findByProject_ProjectNo(int projectNo);

}
