package com.greedy.dduckleaf.settlement.check.service;

import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentHistory;
import com.greedy.dduckleaf.settlement.check.entity.SettlementPaymentInfo;
import com.greedy.dduckleaf.settlement.check.repository.SettlementPaymentHistoryForFarmerCheckRepository;
import com.greedy.dduckleaf.settlement.check.repository.SettlementPaymentInfoForFarmerCheckRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : SettlementFarmerCheckService
 * Comment : 프로젝트 정산정보 확인 업무에 사용되는 트랜젝션 메소드를 작성하였습니다.
 *
 * History
 * 2022-05-10 (장민주) 처음 작성
 * 2022-05-11 (장민주) modifySettlementPaymentInfo 서비스메소드 작성
 * 2022-05-11 (장민주) saveSettlementPaymentHistory 내부연산 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Service
public class SettlementCheckService {

    @Autowired
    private final SettlementPaymentInfoForFarmerCheckRepository settlementPaymentInfoRepository;
    @Autowired
    private final SettlementPaymentHistoryForFarmerCheckRepository settlementPaymentHistoryRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public SettlementCheckService(SettlementPaymentInfoForFarmerCheckRepository settlementPaymentInfoRepository,
                                  SettlementPaymentHistoryForFarmerCheckRepository settlementPaymentHistoryRepository,
                                  ModelMapper modelMapper) {
        this.settlementPaymentInfoRepository = settlementPaymentInfoRepository;
        this.settlementPaymentHistoryRepository = settlementPaymentHistoryRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * modifySettlementPaymentInfo: 파머의 정산정보 확인여부를 데이터베이스에 업데이트 요청하는 메소드입니다.
     * @param settlementPaymentInfoNo: 회차별 정산금 지급내역번호
     * @return 데이터 수정 성공실패 여부
     * @author 장민주
     */
    @Transactional
    public String modifySettlementPaymentInfo(int settlementPaymentInfoNo) {

        /* 식별번호로 회차별 정산금 지급내역 조회 */
        SettlementPaymentInfo settlementPaymentInfo = settlementPaymentInfoRepository.findById(settlementPaymentInfoNo).get();

        /* 조회한 엔티티의 확인여부컬럼 데이터 수정 */
        settlementPaymentInfo.setSettlementPaymentStatus("Y");
        settlementPaymentInfoRepository.save(settlementPaymentInfo);

        /* 정산금 지급내역 변동이력을 새롭게 추가한다 */
        saveSettlementPaymentHistory(settlementPaymentInfo);

        /* 데이터 수정 성공 메시지 반환 */
        String modifyResult = "";

        if(settlementPaymentInfo.getSettlementPaymentStatus().equals("Y")) {
            modifyResult = "확인 접수가 완료되었습니다.";
        }
        if(settlementPaymentInfo.getSettlementPaymentStatus().equals("N")) {
            modifyResult = "확인 접수에 실패하였습니다.";
        }

        return modifyResult;
    }

    /**
     * saveSettlementPaymentHistory: 회차별 정산금 지급내역 테이블 변동에 따른
     *                               회차별 정산금 지급내역 히스토리에 새로운 행을 추가 요청하는 메소드입니다.
     * @param settlementPaymentInfo: 변동이 발생한 회차별 정산금 지급내역
     * @author 장민주
     */
    @Transactional
    public void saveSettlementPaymentHistory(SettlementPaymentInfo settlementPaymentInfo) {

        SettlementPaymentHistory settlementPaymentHistory = new SettlementPaymentHistory();
        /* 지급상태변경에 따른 히스토리 데이터 추가 */
        settlementPaymentHistory.setSettlementPaymentInfo(settlementPaymentInfo);
        settlementPaymentHistory.setSettlementPaymentHistoryDate(getDateAndTime());
        settlementPaymentHistory.setSettlementPaymentHistoryCategory("지급상태변경");
        settlementPaymentHistory.setSettlementStatus("확인");

        settlementPaymentHistoryRepository.save(settlementPaymentHistory);
    }

}
