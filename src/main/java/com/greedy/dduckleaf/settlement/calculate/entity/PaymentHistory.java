package com.greedy.dduckleaf.settlement.calculate.entity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
