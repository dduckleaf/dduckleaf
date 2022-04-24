package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
    private java.sql.Date paymentResultDate;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

}
