package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

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

    public RefundingHistoryDTO() {}

    public RefundingHistoryDTO(int refundingHitsoryNo, String managerType, String refundingHistoryDate,
                               String refundingStatus, String historyCategory, int refundingAmount, String refundingRefuseReason,
                               String refundingHistoryCategory, int refundingInfoNo, int refundObjectionNo,
                               int refundingMemberNo, List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.refundingHitsoryNo = refundingHitsoryNo;
        this.managerType = managerType;
        this.refundingHistoryDate = refundingHistoryDate;
        this.refundingStatus = refundingStatus;
        this.historyCategory = historyCategory;
        this.refundingAmount = refundingAmount;
        this.refundingRefuseReason = refundingRefuseReason;
        this.refundingHistoryCategory = refundingHistoryCategory;
        this.refundingInfoNo = refundingInfoNo;
        this.refundObjectionNo = refundObjectionNo;
        this.refundingMemberNo = refundingMemberNo;
        this.settlementChangeHistoryList = settlementChangeHistoryList;
    }

    public int getRefundingHitsoryNo() {
        return refundingHitsoryNo;
    }

    public void setRefundingHitsoryNo(int refundingHitsoryNo) {
        this.refundingHitsoryNo = refundingHitsoryNo;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getRefundingHistoryDate() {
        return refundingHistoryDate;
    }

    public void setRefundingHistoryDate(String refundingHistoryDate) {
        this.refundingHistoryDate = refundingHistoryDate;
    }

    public String getRefundingStatus() {
        return refundingStatus;
    }

    public void setRefundingStatus(String refundingStatus) {
        this.refundingStatus = refundingStatus;
    }

    public String getHistoryCategory() {
        return historyCategory;
    }

    public void setHistoryCategory(String historyCategory) {
        this.historyCategory = historyCategory;
    }

    public int getRefundingAmount() {
        return refundingAmount;
    }

    public void setRefundingAmount(int refundingAmount) {
        this.refundingAmount = refundingAmount;
    }

    public String getRefundingRefuseReason() {
        return refundingRefuseReason;
    }

    public void setRefundingRefuseReason(String refundingRefuseReason) {
        this.refundingRefuseReason = refundingRefuseReason;
    }

    public String getRefundingHistoryCategory() {
        return refundingHistoryCategory;
    }

    public void setRefundingHistoryCategory(String refundingHistoryCategory) {
        this.refundingHistoryCategory = refundingHistoryCategory;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
    }

    public int getRefundObjectionNo() {
        return refundObjectionNo;
    }

    public void setRefundObjectionNo(int refundObjectionNo) {
        this.refundObjectionNo = refundObjectionNo;
    }

    public int getRefundingMemberNo() {
        return refundingMemberNo;
    }

    public void setRefundingMemberNo(int refundingMemberNo) {
        this.refundingMemberNo = refundingMemberNo;
    }

    public List<SettlementChangeHistoryDTO> getSettlementChangeHistoryList() {
        return settlementChangeHistoryList;
    }

    public void setSettlementChangeHistoryList(List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.settlementChangeHistoryList = settlementChangeHistoryList;
    }

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
