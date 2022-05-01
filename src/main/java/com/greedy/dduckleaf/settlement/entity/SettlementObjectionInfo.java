package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementObjectionInfo")
@Table(name = "TBL_SETTLEMENT_OBJECTION_INFO")
public class SettlementObjectionInfo {

    @Id
    @Column(name = "SETTLEMENT_OBJECTION_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementObjectionInfoNo;                          //이의신청번호

    @Column(name = "SETTLEMENT_OBJECTION_CONTENT")
    private String settlementObjectionContent;                      //이의신청내용

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SETTLEMENT_PAYMENT_HISTORY_NO")
    private SettlementPaymentHistory settlementPaymentHistory;      //지급이력

    @OneToMany(mappedBy = "settlementObjectionInfo")
    private List<SettlementObjectionHistory> settlementObjectionHistoryList;

    @Override
    public String toString() {
        return "SettlementObjectionInfo{" +
                "settlementObjectionInfoNo=" + settlementObjectionInfoNo +
                ", settlementPaymentHistory=" + settlementPaymentHistory +
                ", settlementObjectionContent='" + settlementObjectionContent + '\'' +
                '}';
    }
}
