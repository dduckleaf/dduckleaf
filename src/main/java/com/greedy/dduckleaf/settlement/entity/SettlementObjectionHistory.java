package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementObjectionHistory")
@Table(name = "TBL_SETTLEMENT_OBJECTION_ HISTORY")
public class SettlementObjectionHistory {

    @Id
    @Column(name = "SETTLEMENT_OBJECTION_HISTORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementObjectionHistoryNo;                   //이의신청처리이력번호

    @Column(name = "SETTLEMENT_OBJECTION_HANDLE_STATUS")
    private String settlementObjectionHandleStatus;             //처리상태

    @Column(name = "SETTLEMENT_OBJECTION_HANDLE_DATE")
    private String settlementObjectionHandleDate;               //상태변경일

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_OBJECTION_INFO_NO")
    private SettlementObjectionInfo settlementObjectionInfo;    //이의신청내역

    @OneToMany(mappedBy = "settlementObjectionHistory")
    private List<SettlementPaymentHistory> settlementPaymentHistoryList;

    @OneToMany(mappedBy = "settlementObjectionHistory")
    private List<SettlementChangeHistory> settlementChangeHistoryList;

    @Override
    public String toString() {
        return "SettlementObjectionHistory{" +
                "settlementObjectionHistoryNo=" + settlementObjectionHistoryNo +
                ", settlementObjectionHandleStatus='" + settlementObjectionHandleStatus + '\'' +
                ", settlementObjectionHandleDate='" + settlementObjectionHandleDate + '\'' +
                ", settlementObjectionInfo=" + settlementObjectionInfo +
                '}';
    }
}
