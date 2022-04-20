package com.greedy.dduckleaf.funding.regist.entity;

import javax.persistence.*;

@Entity(name = "PaymentReservationForFunding")
@Table(name = "TBL_PAYMENT_RESERVATION")
public class PaymentReservation {

    @Id
    @Column(name = "PAYMENT_RESERVATION_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentReservationNo;

    @Column(name = "FUNDING_TOTAL_AMOUNT")
    private int fundingTotalAmount;

    @Column(name = "PAYMENT_DUE_DATE")
    private java.sql.Date paymentDueDate;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;



}
