package com.greedy.dduckleaf.settlement.check.repository;

import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : SettlementPaymentInfoForFarmerCheckRepository
 * Comment : SettlementPaymentInfo 엔티티를 이용하여 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-10 (장민주) 처음 작성
 * 2022-05-10 (장민주)
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface SettlementPaymentInfoForFarmerCheckRepository extends JpaRepository<SettlementPaymentInfo, Integer> {
}
