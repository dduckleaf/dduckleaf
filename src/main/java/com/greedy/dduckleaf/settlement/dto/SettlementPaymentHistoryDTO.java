package com.greedy.dduckleaf.settlement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SettlementPaymentHistoryDTO {

    private int settlementPaymentHistoryNo;                                     //지급이력번호
    private String settlementStatus;                                            //지급상태
    private String settlementPaymentHistoryDate;                                //상태변경일
    private String settlementPaymentHistoryCategory;                            //정산금 지급 이력 구분
    private SettlementPaymentInfoDTO settlementPaymentInfo;                        //회차별정산금지급내역번호
    private SettlementObjectionHistoryDTO settlementObjectionHistory;           //이의신청처리이력번호
    private List<SettlementObjectionInfoDTO> settlementObjectionInfoList;

    @Override
    public String toString() {
        return "SettlementPaymentHistory{" +
                "settlementPaymentHistoryNo=" + settlementPaymentHistoryNo +
                ", settlementStatus='" + settlementStatus + '\'' +
                ", settlementPaymentHistoryDate='" + settlementPaymentHistoryDate + '\'' +
                ", settlementPaymentHistoryCategory='" + settlementPaymentHistoryCategory + '\'' +
                ", settlementPaymentInfo=" + settlementPaymentInfo +
                ", settlementObjectionHistory=" + settlementObjectionHistory +
                '}';
    }
}
