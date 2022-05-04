package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

