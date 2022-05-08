package com.greedy.dduckleaf.settlement.calculate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SettlementPaymentRoundRateDTO {

    private int settlementPaymentRoundRateNo;           //정산금지급기준회차별지급율번호
    private int settlementPaymentRound;                 //지급회차
    private int settlementPaymentRate;                  //지급비율

    @Override
    public String toString() {
        return "SettlementPaymentRoundRate{" +
                "settlementPaymentRoundRateNo=" + settlementPaymentRoundRateNo +
                ", settlementPaymentRound=" + settlementPaymentRound +
                ", settlementPaymentRate=" + settlementPaymentRate +
                '}';
    }
}
