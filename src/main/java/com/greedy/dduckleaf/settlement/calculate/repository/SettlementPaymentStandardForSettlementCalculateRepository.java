package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentStandard;
import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentStandardPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : SettlementPaymentStandardForSettlementCalculateRepository
 * Comment : SettlementPaymentStandard 엔티티를 이용하며 구현한 엔티티 저장소입니다.
 *
 * History
 * 2022-05-08 (장민주) 처음 작성
 * 2022-05-08 (장민주) findAllByStandardName 쿼리메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface SettlementPaymentStandardForSettlementCalculateRepository
        extends JpaRepository<SettlementPaymentStandard, SettlementPaymentStandardPK> {

    /**
     * findAllByStandardName: 정산정보기준명으로 정산정보기준 데이터 조회 요청 메소드입니다.
     * @param standardName 기준명
     * @return 정산정보기준 정보
     * @author 장민주
     */
    List<SettlementPaymentStandard> findAllByStandardName(String standardName);
}
