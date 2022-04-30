package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementPaymentHistory")
@Table(name = "TBL_SETTLEMENT_PAYMENT_HISTORY")
public class SettlementPaymentHistory {

    @Id
    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementPaymentHistoryNo;                                     //지급이력번호

    @Column(name = "SETTLEMENT_STATUS", nullable = true)
    private String settlementStatus;                                            //지급상태

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_DATE")
    private String settlementPaymentHistoryDate;                                //상태변경일

    @Column(name = "SETTLEMENT_PAYMENT_HISTORY_CATEGORY")
    private String settlementPaymentHistoryCategory;                            //정산금 지급 이력 구분

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_INFO_NO")
    private SettlementPaymentInfo settlementPaymentInfo;                        //회차별정산금지급내역번호

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_SETTLEMENT_OBJECTION_HISTORY_NO", nullable = true)
    private SettlementObjectionHistory settlementObjectionHistory;              //이의신청처리이력번호

    @OneToMany(mappedBy = "settlementPaymentHistory")
    private List<SettlementObjectionInfo> settlementObjectionInfoList;



    @Override
    public String toString() {
        return "SettlementPaymentHistory{" +
                "settlementPaymentHistoryNo=" + settlementPaymentHistoryNo +
                ", settlementStatus='" + settlementStatus + '\'' +
                ", settlementPaymentHistoryDate='" + settlementPaymentHistoryDate + '\'' +
                ", settlementPaymentHistoryCategory='" + settlementPaymentHistoryCategory + '\'' +
                ", settlementPaymentInfo=" + settlementPaymentInfo +
                ", settlementObjectionHistory=" + settlementObjectionHistory +
                '}';
    }
}
