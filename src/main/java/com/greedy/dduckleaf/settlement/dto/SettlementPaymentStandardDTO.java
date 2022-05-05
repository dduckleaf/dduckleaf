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
public class SettlementPaymentStandardDTO {

    private int settlementPaymentStandardNo;                            //정산금지급기준번호
    private String standardName;                                        //기준명
    private String settlementPaymentStatus;                             //활성화여부
    private SettlementPaymentRoundRateDTO settlementPaymentRoundRate; //정산금지급기준회차별지급율번호
    private List<SettlementPaymentInfoDTO> settlementPaymentInfoList;

    @Override
    public String toString() {
        return "SettlementPaymentStandard{" +
                "settlementPaymentStandardNo=" + settlementPaymentStandardNo +
                ", standardName='" + standardName + '\'' +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentRoundRate=" + settlementPaymentRoundRate +
                '}';
    }
}
