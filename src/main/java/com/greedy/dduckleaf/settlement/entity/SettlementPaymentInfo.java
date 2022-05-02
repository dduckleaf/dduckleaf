package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentInfo")
@Table(name = "TBL_SETTLEMENT_PAYMENT_INFO")
public class SettlementPaymentInfo {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentInfoNo;                            //회차별정산금지급내역번호

    @Column(name = "SETTLEMENT_PAYMENT_AMOUNT")
    private int settlementPaymentAmount;                            //지급금액

    @Column(name = "FARMER_SETTLEMENT_CHECK_STATUS")
    private String farmerSettlementCheckStatus;                     //파머 확인여부

    @Column(name = "SETTLEMENT_PAYMENT_DATE")
    private String settlementPaymentDate;                           //지급일

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_INFO_NO")
    private SettlementInfo settlementInfo;                          //정산정보

    @Column(name = "SETTLEMENT_PAYMENT_STATUS")
    private String settlementPaymentStatus;                         //지급상태

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_STANDARD_NO")
    private SettlementPaymentStandard settlementPaymentStandard;    //정산금지급기준

    @OneToMany(mappedBy = "settlementPaymentInfo")
    private List<SettlementPaymentHistory> settlementPaymentHistoryList;

    @Override
    public String toString() {
        return "SettlementPaymentInfo{" +
                "settlementPaymentInfoNo=" + settlementPaymentInfoNo +
                ", settlementPaymentAmount=" + settlementPaymentAmount +
                ", farmerSettlementCheckStatus='" + farmerSettlementCheckStatus + '\'' +
                ", settlementPaymentDate='" + settlementPaymentDate + '\'' +
                ", settlementInfo=" + settlementInfo +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentStandard=" + settlementPaymentStandard +
                '}';
    }
}
