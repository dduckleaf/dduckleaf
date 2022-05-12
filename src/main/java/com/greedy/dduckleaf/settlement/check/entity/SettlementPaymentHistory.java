package com.greedy.dduckleaf.settlement.check.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "SettlementPaymentHistoryForFarmerCheck")
@Table(name = "TBL_SETTLEMENT_PAYMENT_HISTORY")
@DynamicInsert
public class SettlementPaymentHistory {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentHistoryNo;                                 //지급이력번호

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_INFO_NO")
    private SettlementPaymentInfo settlementPaymentInfo;                    //회차별정산금지급내역번호

    @Column(name = "SETTLEMENT_STATUS", nullable = true)
    private String settlementStatus;                                        //지급상태

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_DATE")
    private String settlementPaymentHistoryDate;                            //상태변경일

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_CATEGORY")
    private String settlementPaymentHistoryCategory;                        //정산금 지급 이력 구분

    public SettlementPaymentHistory() {}

    public SettlementPaymentHistory(int settlementPaymentHistoryNo, SettlementPaymentInfo settlementPaymentInfo,
                                    String settlementStatus, String settlementPaymentHistoryDate,
                                    String settlementPaymentHistoryCategory) {
        this.settlementPaymentHistoryNo = settlementPaymentHistoryNo;
        this.settlementPaymentInfo = settlementPaymentInfo;
        this.settlementStatus = settlementStatus;
        this.settlementPaymentHistoryDate = settlementPaymentHistoryDate;
        this.settlementPaymentHistoryCategory = settlementPaymentHistoryCategory;
    }

    public int getSettlementPaymentHistoryNo() {
        return settlementPaymentHistoryNo;
    }

    public void setSettlementPaymentHistoryNo(int settlementPaymentHistoryNo) {
        this.settlementPaymentHistoryNo = settlementPaymentHistoryNo;
    }

    public SettlementPaymentInfo getSettlementPaymentInfo() {
        return settlementPaymentInfo;
    }

    public void setSettlementPaymentInfo(SettlementPaymentInfo settlementPaymentInfo) {
        this.settlementPaymentInfo = settlementPaymentInfo;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getSettlementPaymentHistoryDate() {
        return settlementPaymentHistoryDate;
    }

    public void setSettlementPaymentHistoryDate(String settlementPaymentHistoryDate) {
        this.settlementPaymentHistoryDate = settlementPaymentHistoryDate;
    }

    public String getSettlementPaymentHistoryCategory() {
        return settlementPaymentHistoryCategory;
    }

    public void setSettlementPaymentHistoryCategory(String settlementPaymentHistoryCategory) {
        this.settlementPaymentHistoryCategory = settlementPaymentHistoryCategory;
    }

    @Override
    public String toString() {
        return "SettlementPaymentHistory{" +
                "settlementPaymentHistoryNo=" + settlementPaymentHistoryNo +
                ", settlementPaymentInfo=" + settlementPaymentInfo +
                ", settlementStatus='" + settlementStatus + '\'' +
                ", settlementPaymentHistoryDate='" + settlementPaymentHistoryDate + '\'' +
                ", settlementPaymentHistoryCategory='" + settlementPaymentHistoryCategory + '\'' +
//                ", settlementObjectionHistoryNo=" + settlementObjectionHistoryNo +
                '}';
    }
}
