package com.greedy.dduckleaf.refund.examine.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "SettlementChangeHistoryForRefundingFarmerExamine")
@Table(name = "TBL_SETTLEMENT_CHANGE_HISTORY")
public class SettlementChangeHistory {
    @Id
    @Column(name = "SETTLEMENT_CHANGE_HISTORY_NO")
    private int settlementChangeHistoryNo;

    @Column(name = "CHANGED_AMOUNT")
    private int changedAmount;

    @Column(name = "CHANGED_REASON")
    private String changedReason;

    @Column(name = "CHANGED_DATE")
    private String changedDate;

    @Column(name = "SETTLEMENT_INFO_NO")
    private int settlementInfoNo;

    @Column(name = "SETTLEMENT_CHANGED_CATEGORY")
    private int settlementChangedCategory;

    @Column(name = "SETTLEMENT_OBJECTION_HISTORY_NO")
    private int settlementObjectionHistoryNo;

    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHistoryNo;
}
