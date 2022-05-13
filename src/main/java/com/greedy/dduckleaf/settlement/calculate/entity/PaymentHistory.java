package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.*;

@Entity(name = "PaymentHistoryForSettlementCalculate")
@Table(name = "TBL_PAYMENT_HISTORY")
public class PaymentHistory {

    @Id
    @Column(name = "PAYMENT_HISTORY_NO")
    private int paymentHistoryNo;                   //결제이력 번호

    @Column(name = "PAYMENT_RESULT_STATUS")
    private String paymentResultStatus;             //결제 결과 상태

    @Column(name = "PAYMENT_RESULT_DATE")
    private String paymentResultDate;               //결제 결과 발생일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private FundingInfo fundingInfo;                //펀딩 신청 내역 번호

    public PaymentHistory() {}

    public PaymentHistory(int paymentHistoryNo, String paymentResultStatus, String paymentResultDate, FundingInfo fundingInfo) {
        this.paymentHistoryNo = paymentHistoryNo;
        this.paymentResultStatus = paymentResultStatus;
        this.paymentResultDate = paymentResultDate;
        this.fundingInfo = fundingInfo;
    }

    public int getPaymentHistoryNo() {
        return paymentHistoryNo;
    }

    public void setPaymentHistoryNo(int paymentHistoryNo) {
        this.paymentHistoryNo = paymentHistoryNo;
    }

    public String getPaymentResultStatus() {
        return paymentResultStatus;
    }

    public void setPaymentResultStatus(String paymentResultStatus) {
        this.paymentResultStatus = paymentResultStatus;
    }

    public String getPaymentResultDate() {
        return paymentResultDate;
    }

    public void setPaymentResultDate(String paymentResultDate) {
        this.paymentResultDate = paymentResultDate;
    }

    public FundingInfo getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfo fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    @Override
    public String toString() {
        return "PaymentHistory{" +
                "paymentHistoryNo=" + paymentHistoryNo +
                ", paymentResultStatus='" + paymentResultStatus + '\'' +
                ", paymentResultDate='" + paymentResultDate + '\'' +
                ", fundingInfo=" + fundingInfo +
                '}';
    }
}
