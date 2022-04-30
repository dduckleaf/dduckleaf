package com.greedy.dduckleaf.settlement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SettlementChangeHistoryDTO {

    private int settlementChangeHistoryNo;                          //정산히스토리
    private SettlementInfoDTO settlementInfo;                          //정산정보
    private SettlementChangedCategoryDTO settlementChangedCategory; //정산정보 변경대상 구분
    private SettlementObjectionHistoryDTO settlementObjectionHistory;  //이의신청처리이력
    private RefundingHistoryDTO refundingHistory;                   //환불히스토리
    private String changedReason;                                   //변경사유
    private String changedDate;                                     //변경일
    private int changedAmount;                                      //변경금액

    @Override
    public String toString() {
        return "SettlementChangeHistory{" +
                "settlementChangeHistoryNo=" + settlementChangeHistoryNo +
                ", settlementInfo=" + settlementInfo +
                ", settlementChangedCategory=" + settlementChangedCategory +
                ", settlementObjectionHistory=" + settlementObjectionHistory +
                ", refundingHistory=" + refundingHistory +
                ", changedReason='" + changedReason + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", changedAmount=" + changedAmount +
                '}';
    }
}
