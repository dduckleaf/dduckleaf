package com.greedy.dduckleaf.settlement.check.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SettlementPaymentRoundRateForFarmerCheck")
@Table(name = "TBL_SETTLEMENT_PAYMENT_ROUND_RATE")
public class SettlementPaymentRoundRate {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    private int settlementPaymentRoundRateNo;           //정산금지급기준회차별지급율번호

    @Column(name = "SETTLEMENT_PAYMENT_ROUND")
    private int settlementPaymentRound;                 //지급회차

    @Column(name = "SETTLEMENT_PAYMENT_RATE")
    private double settlementPaymentRate;                  //지급비율

    public SettlementPaymentRoundRate() {}

    public SettlementPaymentRoundRate(int settlementPaymentRoundRateNo, int settlementPaymentRound, double settlementPaymentRate) {
        this.settlementPaymentRoundRateNo = settlementPaymentRoundRateNo;
        this.settlementPaymentRound = settlementPaymentRound;
        this.settlementPaymentRate = settlementPaymentRate;
    }

    public int getSettlementPaymentRoundRateNo() {
        return settlementPaymentRoundRateNo;
    }

    public void setSettlementPaymentRoundRateNo(int settlementPaymentRoundRateNo) {
        this.settlementPaymentRoundRateNo = settlementPaymentRoundRateNo;
    }

    public int getSettlementPaymentRound() {
        return settlementPaymentRound;
    }

    public void setSettlementPaymentRound(int settlementPaymentRound) {
        this.settlementPaymentRound = settlementPaymentRound;
    }

    public double getSettlementPaymentRate() {
        return settlementPaymentRate;
    }

    public void setSettlementPaymentRate(double settlementPaymentRate) {
        this.settlementPaymentRate = settlementPaymentRate;
    }

    @Override
    public String toString() {
        return "SettlementPaymentRoundRate{" +
                "settlementPaymentRoundRateNo=" + settlementPaymentRoundRateNo +
                ", settlementPaymentRound=" + settlementPaymentRound +
                ", settlementPaymentRate=" + settlementPaymentRate +
                '}';
    }
}
