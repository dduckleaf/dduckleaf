//package com.greedy.dduckleaf.settlement.calculate.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@Entity(name = "SettlementChangeHistory")
//@Table(name = "TBL_SETTLEMENT_CHANGE_HISTORY")
//public class SettlementChangeHistory {
//
//    @Id
//    @Column(name = "")
//    private int settlementChangeHistoryNo;
//
//    @Column(name = "")
//    private int changedAmount;
//
//    @Column(name = "")
//    private String changedReason;
//
//    @Column(name = "")
//    private String changedDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "")
//    private SettlementInfo settlementInfo;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "SETTLEMENT_CHANGED_CATEGORY")
//    private SettlementChangedCategory settlementChangedCategory;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "SETTLEMENT_OBJECTION_HISTORY_NO", nullable = true)
//    private SettlementObjectionHistory settlementChangedCategory;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "REFUNDING_HISTORY_NO", nullable = true)
//    private RefundingHistory settlementChangedCategory;
//
//}
//
