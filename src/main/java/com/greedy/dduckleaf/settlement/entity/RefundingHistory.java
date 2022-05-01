package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RefundingHistoryForSettlement")
@Table(name = "TBL_REFUNDING_HISTORY")
public class RefundingHistory {

    @Id
    @Column(name = "REFUNDING_HISTORY_NO")
    private int refundingHitsoryNo;                 //환불히스토리번호

    @Transient
    @Column(name = "MANAGER_TYPE")
    private String managerType;                     //담당자

    @Column(name = "REFUNDING_HISTORY_DATE")
    private String refundingHistoryDate;            //상태변경일

    @Column(name = "REFUNDING_STATUS")
    private String refundingStatus;                 //환불상태

    @Transient
    @Column(name = "HISTORY_CATEGORY")
    private String historyCategory;                 //이력구분

    @Column(name = "REFUNDING_AMOUNT")
    private int refundingAmount;                    //환불액

    @Transient
    @Column(name = "REFUNDING_REFUSE_REASON")
    private String refundingRefuseReason;           //거절사유

    @Transient
    @Column(name = "REFUNDING_HISTORY_CATEGORY")
    private String refundingHistoryCategory;        //환불구분

    @Transient
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;                    //환불 신청 번호

    @Transient
    @Column(name = "REFUND_OBJECTION_NO")
    private int refundObjectionNo;                  //환불 이의신청번호

    @Transient
    @Column(name = "REFUNDING_MEMBER_NO")
    private int refundingMemberNo;                  //이력 발생 대상 회원번호

    @OneToMany(mappedBy = "refundingHistory")
    private List<SettlementChangeHistory> settlementChangeHistoryList;

    @Override
    public String toString() {
        return "RefundingHistory{" +
                "refundingHitsoryNo=" + refundingHitsoryNo +
                ", managerType='" + managerType + '\'' +
                ", refundingHistoryDate='" + refundingHistoryDate + '\'' +
                ", refundingStatus='" + refundingStatus + '\'' +
                ", historyCategory='" + historyCategory + '\'' +
                ", refundingAmount=" + refundingAmount +
                ", refundingRefuseReason='" + refundingRefuseReason + '\'' +
                ", refundingHistoryCategory='" + refundingHistoryCategory + '\'' +
                ", refundingInfoNo=" + refundingInfoNo +
                ", refundObjectionNo=" + refundObjectionNo +
                ", refundingMemberNo=" + refundingMemberNo +
                '}';
    }
}
