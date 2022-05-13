package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@Entity(name = "PaymentHistoryForFunding")
@Table(name = "TBL_PAYMENT_HISTORY")
public class PaymentHistory {

    @Id
    @Column(name = "PAYMENT_HISTORY_NO")
    private int paymentHistoryNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PAYMENT_RESULT_STATUS")
    private String paymentResultStauts;


    @Column(name = "PAYMENT_RESULT_DATE")
    private String paymentResultDate;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    public PaymentHistory() {
    }

    public PaymentHistory(int paymentHistoryNo, int memberNo, String paymentResultStauts, String paymentResultDate, Funding funding) {
        this.paymentHistoryNo = paymentHistoryNo;
        this.memberNo = memberNo;
        this.paymentResultStauts = paymentResultStauts;
        this.paymentResultDate = paymentResultDate;
        this.funding = funding;
    }

    public int getPaymentHistoryNo() {
        return paymentHistoryNo;
    }

    public void setPaymentHistoryNo(int paymentHistoryNo) {
        this.paymentHistoryNo = paymentHistoryNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getPaymentResultStauts() {
        return paymentResultStauts;
    }

    public void setPaymentResultStauts(String paymentResultStauts) {
        this.paymentResultStauts = paymentResultStauts;
    }

    public String getPaymentResultDate() {
        return paymentResultDate;
    }

    public void setPaymentResultDate(String paymentResultDate) {
        this.paymentResultDate = paymentResultDate;
    }

    public Funding getFunding() {
        return funding;
    }

    public void setFunding(Funding funding) {
        this.funding = funding;
    }

    @Override
    public String toString() {
        return "PaymentHistory{" +
                "paymentHistoryNo=" + paymentHistoryNo +
                ", memberNo=" + memberNo +
                ", paymentResultStauts='" + paymentResultStauts + '\'' +
                ", paymentResultDate=" + paymentResultDate +
                '}';
    }
}

