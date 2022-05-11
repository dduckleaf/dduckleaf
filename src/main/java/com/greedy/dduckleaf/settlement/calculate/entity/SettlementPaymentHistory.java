package com.greedy.dduckleaf.settlement.calculate.entity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentHistoryForCalculate")
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

    @Column(name = "SETTLEMENT_STATUS")
    private String settlementStatus;                                        //지급상태

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_DATE")
    private String settlementPaymentHistoryDate;                            //상태변경일

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_CATEGORY")
    private String settlementPaymentHistoryCategory;                        //정산금 지급 이력 구분

//    @Column(name = "REF_SETTLEMENT_OBJECTION_HISTORY_NO", nullable = true)
//    private int settlementObjectionHistoryNo;                               //이의신청처리이력번호

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
