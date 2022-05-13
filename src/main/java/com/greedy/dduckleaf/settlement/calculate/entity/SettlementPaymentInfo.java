package com.greedy.dduckleaf.settlement.calculate.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "SettlementPaymentInfoForCalculate")
@Table(name = "TBL_SETTLEMENT_PAYMENT_INFO")
@DynamicInsert
public class SettlementPaymentInfo {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentInfoNo;                                        //회차별정산금지급내역번호

    @Column(name = "SETTLEMENT_PAYMENT_AMOUNT")
    private int settlementPaymentAmount;                                        //지급금액

    @Column(name = "FARMER_SETTLEMENT_CHECK_STATUS", nullable = true)
    private String farmerSettlementCheckStatus;                                 //파머 확인여부

    @Column(name = "SETTLEMENT_PAYMENT_DATE", nullable = true)
    private String settlementPaymentDate;                                       //지급일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_INFO_NO")
    private SettlementInfo settlementInfo;                                      //정산정보

    @Column(name = "SETTLEMENT_PAYMENT_STATUS", nullable = true)
    private String settlementPaymentStatus;                                     //지급상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
        @JoinColumn(
            name = "SETTLEMENT_PAYMENT_STANDARD_NO",
            referencedColumnName = "SETTLEMENT_PAYMENT_STANDARD_NO"
        ),
        @JoinColumn(
            name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO",
            referencedColumnName = "SETTLEMENT_PAYMENT_ROUND_RATE_NO"
        )
    })
    private SettlementPaymentStandard settlementPaymentStandard;               //정산금지급기준

    public SettlementPaymentInfo() {}

    public SettlementPaymentInfo(int settlementPaymentInfoNo, int settlementPaymentAmount, String farmerSettlementCheckStatus,
                                 String settlementPaymentDate, SettlementInfo settlementInfo, String settlementPaymentStatus,
                                 SettlementPaymentStandard settlementPaymentStandard) {
        this.settlementPaymentInfoNo = settlementPaymentInfoNo;
        this.settlementPaymentAmount = settlementPaymentAmount;
        this.farmerSettlementCheckStatus = farmerSettlementCheckStatus;
        this.settlementPaymentDate = settlementPaymentDate;
        this.settlementInfo = settlementInfo;
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

    public SettlementInfo getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfo settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public String getSettlementPaymentStatus() {
        return settlementPaymentStatus;
    }

    public void setSettlementPaymentStatus(String settlementPaymentStatus) {
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

    public SettlementPaymentStandard getSettlementPaymentStandard() {
        return settlementPaymentStandard;
    }

    public void setSettlementPaymentStandard(SettlementPaymentStandard settlementPaymentStandard) {
        this.settlementPaymentStandard = settlementPaymentStandard;
    }

    @Override
    public String toString() {
        return "SettlementPaymentInfo{" +
                "settlementPaymentInfoNo=" + settlementPaymentInfoNo +
                ", settlementPaymentAmount=" + settlementPaymentAmount +
                ", farmerSettlementCheckStatus='" + farmerSettlementCheckStatus + '\'' +
                ", settlementPaymentDate='" + settlementPaymentDate + '\'' +
                ", settlementInfo=" + settlementInfo +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentStandard=" + settlementPaymentStandard +
                '}';
    }
}
