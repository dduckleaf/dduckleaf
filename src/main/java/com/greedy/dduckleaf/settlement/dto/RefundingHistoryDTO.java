package com.greedy.dduckleaf.settlement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RefundingHistoryDTO {

    private int refundingHitsoryNo;                 //환불히스토리번호
    private String managerType;                     //담당자
    private String refundingHistoryDate;            //상태변경일
    private String refundingStatus;                 //환불상태
    private String historyCategory;                 //이력구분
    private int refundingAmount;                    //환불액
    private String refundingRefuseReason;           //거절사유
    private String refundingHistoryCategory;        //환불구분
    private int refundingInfoNo;                    //환불 신청 번호
    private int refundObjectionNo;                  //환불 이의신청번호
    private int refundingMemberNo;                  //이력 발생 대상 회원번호
    private List<SettlementChangeHistoryDTO> settlementChangeHistoryList;

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
