package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentRoundRate")
@Table(name = "TBL_SETTLEMENT_PAYMENT_ROUND_RATE")
public class SettlementPaymentRoundRate {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentRoundRateNo;           //정산금지급기준회차별지급율번호

    @Column(name = "SETTLEMENT_PAYMENT_ROUND")
    private int settlementPaymentRound;                 //지급회차

    @Column(name = "SETTLEMENT_PAYMENT_RATE")
    private int settlementPaymentRate;                  //지급비율

    @OneToMany(mappedBy = "settlementPaymentRoundRate")
    private List<SettlementPaymentStandard> settlementPaymentStandardList;

    @Override
    public String toString() {
        return "SettlementPaymentRoundRate{" +
                "settlementPaymentRoundRateNo=" + settlementPaymentRoundRateNo +
                ", settlementPaymentRound=" + settlementPaymentRound +
                ", settlementPaymentRate=" + settlementPaymentRate +
                '}';
    }
}
