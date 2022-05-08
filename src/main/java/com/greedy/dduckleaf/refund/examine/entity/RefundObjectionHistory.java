package com.greedy.dduckleaf.refund.examine.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundObjectionHistory")
@Table(name = "TBL_REFUND_OBJECTION_HISTORY")
public class RefundObjectionHistory {

    @Id
    @Column(name = "REFUND_OBJECTION_HISTORY_NO")
    private int refundObjectionHistoryNo;

    @Column(name = "HISTORY_DATE")
    private String historyDate;

    @Column(name = "HISTORY_CATEGORY")
    private String historyCategory;

    @Column(name = "REFUSE_REASON")
    private String refuseReason;

    @Column(name = "REFUND_OBJECTION_NO")
    private int refundObjectionNo;
}
