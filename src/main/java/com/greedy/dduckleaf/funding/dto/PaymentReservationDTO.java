package com.greedy.dduckleaf.funding.dto;

import java.sql.Date;

public class PaymentReservationDTO {

    private int paymentReservationNo;
    private int fundingTotalAmount;
    private java.sql.Date paymentDueDate;
    private int fundingInfoNo;
    private int memberNo;
    private int projectNo;

    public PaymentReservationDTO() {
    }

    public PaymentReservationDTO(int paymentReservationNo, int fundingTotalAmount, Date paymentDueDate, int fundingInfoNo, int memberNo, int projectNo) {
        this.paymentReservationNo = paymentReservationNo;
        this.fundingTotalAmount = fundingTotalAmount;
        this.paymentDueDate = paymentDueDate;
        this.fundingInfoNo = fundingInfoNo;
        this.memberNo = memberNo;
        this.projectNo = projectNo;
    }

    public int getPaymentReservationNo() {
        return paymentReservationNo;
    }

    public void setPaymentReservationNo(int paymentReservationNo) {
        this.paymentReservationNo = paymentReservationNo;
    }

    public int getFundingTotalAmount() {
        return fundingTotalAmount;
    }

    public void setFundingTotalAmount(int fundingTotalAmount) {
        this.fundingTotalAmount = fundingTotalAmount;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "PaymentReservationDTO{" +
                "paymentReservationNo=" + paymentReservationNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", paymentDueDate=" + paymentDueDate +
                ", fundingInfoNo=" + fundingInfoNo +
                ", memberNo=" + memberNo +
                ", projectNo=" + projectNo +
                '}';
    }
}
