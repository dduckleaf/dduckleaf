package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SettlementPaymentStandardPK implements Serializable {

    @Column(name = "SETTLEMENT_PAYMENT_STANDARD_NO")
    private int settlementPaymentStandardNo;                            //정산금지급기준번호

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    private SettlementPaymentRoundRate settlementPaymentRoundRate;      //정산금지급기준회차별지급율번호

    public SettlementPaymentStandardPK() {}

    public SettlementPaymentStandardPK(int settlementPaymentStandardNo, SettlementPaymentRoundRate settlementPaymentRoundRate) {
        this.settlementPaymentStandardNo = settlementPaymentStandardNo;
        this.settlementPaymentRoundRate = settlementPaymentRoundRate;
    }

    public int getSettlementPaymentStandardNo() {
        return settlementPaymentStandardNo;
    }

    public void setSettlementPaymentStandardNo(int settlementPaymentStandardNo) {
        this.settlementPaymentStandardNo = settlementPaymentStandardNo;
    }

    public SettlementPaymentRoundRate getSettlementPaymentRoundRate() {
        return settlementPaymentRoundRate;
    }

    public void setSettlementPaymentRoundRate(SettlementPaymentRoundRate settlementPaymentRoundRate) {
        this.settlementPaymentRoundRate = settlementPaymentRoundRate;
    }

    @Override
    public String toString() {
        return "SettlementPaymentStandardPK{" +
                "settlementPaymentStandardNo=" + settlementPaymentStandardNo +
                ", settlementPaymentRoundRate=" + settlementPaymentRoundRate +
                '}';
    }
}
