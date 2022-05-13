package com.greedy.dduckleaf.settlement.check.dto;

public class SettlementPaymentInfoDTO {

    private int settlementPaymentInfoNo;                                        //회차별정산금지급내역번호
    private int settlementPaymentAmount;                                        //지급금액
    private String farmerSettlementCheckStatus;                                 //파머 확인여부
    private String settlementPaymentDate;                                       //지급일
    private String settlementPaymentStatus;                                     //지급상태
    private SettlementPaymentStandardDTO settlementPaymentStandard;             //정산금지급기준

    public SettlementPaymentInfoDTO() {}

    public SettlementPaymentInfoDTO(int settlementPaymentInfoNo, int settlementPaymentAmount, String farmerSettlementCheckStatus,
                                    String settlementPaymentDate, String settlementPaymentStatus,
                                    SettlementPaymentStandardDTO settlementPaymentStandard) {
        this.settlementPaymentInfoNo = settlementPaymentInfoNo;
        this.settlementPaymentAmount = settlementPaymentAmount;
        this.farmerSettlementCheckStatus = farmerSettlementCheckStatus;
        this.settlementPaymentDate = settlementPaymentDate;
        this.settlementPaymentStatus = settlementPaymentStatus;
        this.settlementPaymentStandard = settlementPaymentStandard;
    }

    public int getSettlementPaymentInfoNo() {
        return settlementPaymentInfoNo;
    }

    public void setSettlementPaymentInfoNo(int settlementPaymentInfoNo) {
        this.settlementPaymentInfoNo = settlementPaymentInfoNo;
    }

    public int getSettlementPaymentAmount() {
        return settlementPaymentAmount;
    }

    public void setSettlementPaymentAmount(int settlementPaymentAmount) {
        this.settlementPaymentAmount = settlementPaymentAmount;
    }

    public String getFarmerSettlementCheckStatus() {
        return farmerSettlementCheckStatus;
    }

    public void setFarmerSettlementCheckStatus(String farmerSettlementCheckStatus) {
        this.farmerSettlementCheckStatus = farmerSettlementCheckStatus;
    }

    public String getSettlementPaymentDate() {
        return settlementPaymentDate;
    }

    public void setSettlementPaymentDate(String settlementPaymentDate) {
        this.settlementPaymentDate = settlementPaymentDate;
    }

    public String getSettlementPaymentStatus() {
        return settlementPaymentStatus;
    }

    public void setSettlementPaymentStatus(String settlementPaymentStatus) {
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

    public SettlementPaymentStandardDTO getSettlementPaymentStandard() {
        return settlementPaymentStandard;
    }

    public void setSettlementPaymentStandard(SettlementPaymentStandardDTO settlementPaymentStandard) {
        this.settlementPaymentStandard = settlementPaymentStandard;
    }

    @Override
    public String toString() {
        return "SettlementPaymentInfoDTO{" +
                "settlementPaymentInfoNo=" + settlementPaymentInfoNo +
                ", settlementPaymentAmount=" + settlementPaymentAmount +
                ", farmerSettlementCheckStatus='" + farmerSettlementCheckStatus + '\'' +
                ", settlementPaymentDate='" + settlementPaymentDate + '\'' +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentStandard=" + settlementPaymentStandard +
                '}';
    }
}
