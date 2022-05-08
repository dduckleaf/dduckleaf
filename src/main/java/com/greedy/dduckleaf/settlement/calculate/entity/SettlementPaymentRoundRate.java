package com.greedy.dduckleaf.settlement.calculate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentRoundRateForCalculate")
@Table(name = "TBL_SETTLEMENT_PAYMENT_ROUND_RATE")
public class SettlementPaymentRoundRate {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    private int settlementPaymentRoundRateNo;           //정산금지급기준회차별지급율번호

    @Column(name = "SETTLEMENT_PAYMENT_ROUND")
    private int settlementPaymentRound;                 //지급회차

    @Column(name = "SETTLEMENT_PAYMENT_RATE")
    private double settlementPaymentRate;                  //지급비율

    @Override
    public String toString() {
        return "SettlementPaymentRoundRate{" +
                "settlementPaymentRoundRateNo=" + settlementPaymentRoundRateNo +
                ", settlementPaymentRound=" + settlementPaymentRound +
                ", settlementPaymentRate=" + settlementPaymentRate +
                '}';
    }
}
