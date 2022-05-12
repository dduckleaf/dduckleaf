package com.greedy.dduckleaf.funding.dto;

import com.greedy.dduckleaf.funding.entity.Funding;

public class PaymentHistoryDTO {

    private int paymentHistoryNo;
    private int memberNo;
    private String paymentResultStauts;
    private String paymentResultDate;
    private Funding funding;

    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(int paymentHistoryNo, int memberNo, String paymentResultStauts, String paymentResultDate, Funding funding) {
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
        return "PaymentHistoryDTO{" +
                "paymentHistoryNo=" + paymentHistoryNo +
                ", memberNo=" + memberNo +
                ", paymentResultStauts='" + paymentResultStauts + '\'' +
                ", paymentResultDate='" + paymentResultDate + '\'' +
                ", funding=" + funding +
                '}';
    }
}
