package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "SettlementPaymentStandardForCalculate")
@Table(name = "TBL_SETTLEMENT_PAYMENT_STANDARD")
public class SettlementPaymentStandard {

    @EmbeddedId
    private SettlementPaymentStandardPK settlementPaymentStandardPK;

    @Column(name = "STANDARD_NAME")
    private String standardName;                                        //기준명

    @Column(name = "SETTLEMENT_PAYMENT_STATUS")
    private String settlementPaymentStatus;                             //활성화여부

    public SettlementPaymentStandard() {}

    public SettlementPaymentStandard(SettlementPaymentStandardPK settlementPaymentStandardPK, String standardName, String settlementPaymentStatus) {
        this.settlementPaymentStandardPK = settlementPaymentStandardPK;
        this.standardName = standardName;
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

    public SettlementPaymentStandardPK getSettlementPaymentStandardPK() {
        return settlementPaymentStandardPK;
    }

    public void setSettlementPaymentStandardPK(SettlementPaymentStandardPK settlementPaymentStandardPK) {
        this.settlementPaymentStandardPK = settlementPaymentStandardPK;
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
                "settlementPaymentStandardPK=" + settlementPaymentStandardPK +
                ", standardName='" + standardName + '\'' +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                '}';
    }
}
