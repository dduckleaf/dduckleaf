package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementChangeHistory")
@Table(name = "TBL_SETTLEMENT_CHANGE_HISTORY")
public class SettlementChangeHistory {

    @Id
    @Column(name = "SETTLEMENT_CHANGE_HISTORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementChangeHistoryNo;                          //정산히스토리

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_INFO_NO")
    private SettlementInfo settlementInfo;                          //정산정보

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_CHANGED_CATEGORY")
    private SettlementChangedCategory settlementChangedCategory;    //정산정보 변경대상 구분

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SETTLEMENT_OBJECTION_HISTORY_NO", nullable = true)
    private SettlementObjectionHistory settlementObjectionHistory;        //이의신청처리이력

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER  )
    @JoinColumn(name = "REFUNDING_HISTORY_NO", nullable = true)
    private RefundingHistory refundingHistory;                      //환불히스토리

    @Column(name = "CHANGED_REASON")
    private String changedReason;                                   //변경사유

    @Column(name = "CHANGED_DATE")
    private String changedDate;                                     //변경일

    @Column(name = "CHANGED_AMOUNT")
    private int changedAmount;                                      //변경금액

    @Override
    public String toString() {
        return "SettlementChangeHistory{" +
                "settlementChangeHistoryNo=" + settlementChangeHistoryNo +
                ", settlementInfo=" + settlementInfo +
                ", settlementChangedCategory=" + settlementChangedCategory +
                ", settlementObjectionHistory=" + settlementObjectionHistory +
                ", refundingHistory=" + refundingHistory +
                ", changedReason='" + changedReason + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", changedAmount=" + changedAmount +
                '}';
    }
}
