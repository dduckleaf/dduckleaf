package com.greedy.dduckleaf.settlement.check.entity;
import com.greedy.dduckleaf.settlement.check.entity.SettlementInfo;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentInfoForFarmerCheck")
@Table(name = "TBL_SETTLEMENT_PAYMENT_INFO")
public class SettlementPaymentInfo {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentInfoNo;                                        //회차별정산금지급내역번호

    @Column(name = "SETTLEMENT_PAYMENT_AMOUNT")
    private int settlementPaymentAmount;                                        //지급금액

    @Column(name = "FARMER_SETTLEMENT_CHECK_STATUS", nullable = true)
    private String farmerSettlementCheckStatus;                                 //파머 확인여부

    @Column(name = "SETTLEMENT_PAYMENT_DATE", nullable = true)
    private String settlementPaymentDate;                                       //지급일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_INFO_NO")
    private SettlementInfo settlementInfo;                                      //정산정보

    @Column(name = "SETTLEMENT_PAYMENT_STATUS", nullable = true)
    private String settlementPaymentStatus;                                     //지급상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "SETTLEMENT_PAYMENT_STANDARD_NO", referencedColumnName = "SETTLEMENT_PAYMENT_STANDARD_NO"),
            @JoinColumn(name = "SETTLEMENT_PAYMENT_ROUND_RATE_NO", referencedColumnName = "SETTLEMENT_PAYMENT_ROUND_RATE_NO")
    })
    private SettlementPaymentStandard settlementPaymentStandard;             //정산금지급기준

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
