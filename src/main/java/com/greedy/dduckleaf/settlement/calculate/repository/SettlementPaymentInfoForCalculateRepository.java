package com.greedy.dduckleaf.settlement.calculate.repository;

import com.greedy.dduckleaf.settlement.calculate.entity.SettlementPaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <pre>
 * Class : SettlementPaymentInfoRepository
 * Comment : 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-30 (장민주) 설명
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface SettlementPaymentInfoForCalculateRepository extends JpaRepository<SettlementPaymentInfo, Integer> {

        /**
         * findBySettlementInfo_SettlementInfoNo: 정산정보번호로 회차별 정산금 지급내역 조회를 요청하는 메소드입니다.
         * @param settlementInfoNo 정산정보번호
         * @return 회차별 정산금지급내역
         * @author 장민주
         */
        List<SettlementPaymentInfo> findBySettlementInfo_SettlementInfoNo(int settlementInfoNo);
}
