package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentStandard")
@Table(name = "TBL_SETTLEMENT_PAYMENT_STANDARD")
public class SettlementPaymentStandard {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_STANDARD_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentStandardNo;                            //정산금지급기준번호

    @Column(name = "STANDARD_NAME")
    private String standardName;                                        //기준명

    @Column(name = "SETTLEMENT_PAYMENT_STATUS")
    private String settlementPaymentStatus;                             //활성화여부

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    private SettlementPaymentRoundRate settlementPaymentRoundRate;      //정산금지급기준회차별지급율번호

    @OneToMany(mappedBy = "settlementPaymentStandard")
    private List<SettlementPaymentInfo> settlementPaymentInfoList;

    @Override
    public String toString() {
        return "SettlementPaymentStandard{" +
                "settlementPaymentStandardNo=" + settlementPaymentStandardNo +
                ", standardName='" + standardName + '\'' +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentRoundRate=" + settlementPaymentRoundRate +
                '}';
    }
}
