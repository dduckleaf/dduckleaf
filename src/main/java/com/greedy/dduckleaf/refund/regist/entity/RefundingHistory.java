package com.greedy.dduckleaf.refund.regist.entity;

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
@Entity(name = "RefundingHistoryForRefundingRegist")
@Table(name = "TBL_REFUNDG_HISTORY")
public class RefundingHistory {

    @Id
    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHisotryNo;

    @Column(name = "MANAGER_TYPE")
    private String magagerType;

    @Column(name = "REFUNDING_HISTORY_DATE")
    private String refundingHistoryDate;

    @Column(name = "REFUNDING_STATUS")
    private String refundingStatus;

    @Column(name = "HISTORY_CATEGORY")
    private String historyCategory;

    @Column(name = "REFUNDING_AMOUNT")
    private int refundingAmount;

    @Column(name = "REFUNDING_REFUSE_REASON")
    private String refundingRefuseReason;

    @Column(name = "REFUNDING_HISTORY_CATEGORY")
    private String refundingHistoryCategory;

    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUND_OBJECTION_NO")
    private int refundObjectionNo;

    @Column(name = "REFUNDING_MEMBER_NO")
    private int refundingMemberNo;
}













