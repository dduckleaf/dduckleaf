package com.greedy.dduckleaf.settlement.check.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentStandardForFarmerCheck")
@Table(name = "TBL_SETTLEMENT_PAYMENT_STANDARD")
public class SettlementPaymentStandard {

    @EmbeddedId
    private SettlementPaymentStandardPK settlementPaymentStandardPK;

    @Column(name = "STANDARD_NAME")
    private String standardName;                                        //기준명

    @Column(name = "SETTLEMENT_PAYMENT_STATUS")
    private String settlementPaymentStatus;                             //활성화여부

    @Override
    public String toString() {
        return "SettlementPaymentStandard{" +
                "settlementPaymentStandardPK=" + settlementPaymentStandardPK +
                ", standardName='" + standardName + '\'' +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                '}';
    }
}
