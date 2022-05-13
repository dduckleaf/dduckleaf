package com.greedy.dduckleaf.settlement.check.dto;

public class SettlementPaymentStandardDTO {

    private int settlementPaymentStandardNo;                            //정산금지급기준번호
    private SettlementPaymentRoundRateDTO settlementPaymentRoundRate;   //정산금지급기준회차별지급율
    private String standardName;                                        //기준명
    private String settlementPaymentStatus;                             //활성화여부

    public SettlementPaymentStandardDTO() {}

    public SettlementPaymentStandardDTO(int settlementPaymentStandardNo, SettlementPaymentRoundRateDTO settlementPaymentRoundRate,
                                        String standardName, String settlementPaymentStatus) {
        this.settlementPaymentStandardNo = settlementPaymentStandardNo;
        this.settlementPaymentRoundRate = settlementPaymentRoundRate;
        this.standardName = standardName;
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

    public int getSettlementPaymentStandardNo() {
        return settlementPaymentStandardNo;
    }

    public void setSettlementPaymentStandardNo(int settlementPaymentStandardNo) {
        this.settlementPaymentStandardNo = settlementPaymentStandardNo;
    }

    public SettlementPaymentRoundRateDTO getSettlementPaymentRoundRate() {
        return settlementPaymentRoundRate;
    }

    public void setSettlementPaymentRoundRate(SettlementPaymentRoundRateDTO settlementPaymentRoundRate) {
        this.settlementPaymentRoundRate = settlementPaymentRoundRate;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getSettlementPaymentStatus() {
        return settlementPaymentStatus;
    }

    public void setSettlementPaymentStatus(String settlementPaymentStatus) {
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

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
