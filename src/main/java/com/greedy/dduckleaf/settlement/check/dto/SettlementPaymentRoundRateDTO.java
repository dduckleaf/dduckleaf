package com.greedy.dduckleaf.settlement.check.dto;

public class SettlementPaymentRoundRateDTO {

    private int settlementPaymentRoundRateNo;           //정산금지급기준회차별지급율번호
    private int settlementPaymentRound;                 //지급회차
    private double settlementPaymentRate;                  //지급비율

    public SettlementPaymentRoundRateDTO() {}

    public SettlementPaymentRoundRateDTO(int settlementPaymentRoundRateNo, int settlementPaymentRound, double settlementPaymentRate) {
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
