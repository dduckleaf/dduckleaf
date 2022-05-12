package com.greedy.dduckleaf.settlement.dto;

public class SettlementChangeHistoryDTO {

    private int settlementChangeHistoryNo;                          //정산히스토리
    private SettlementInfoDTO settlementInfo;                          //정산정보
    private SettlementChangedCategoryDTO settlementChangedCategory; //정산정보 변경대상 구분
    private SettlementObjectionHistoryDTO settlementObjectionHistory;  //이의신청처리이력
    private RefundingHistoryDTO refundingHistory;                   //환불히스토리
    private String changedReason;                                   //변경사유
    private String changedDate;                                     //변경일
    private int changedAmount;                                      //변경금액

    public SettlementChangeHistoryDTO() {}

    public SettlementChangeHistoryDTO(int settlementChangeHistoryNo, SettlementInfoDTO settlementInfo,
                                      SettlementChangedCategoryDTO settlementChangedCategory,
                                      SettlementObjectionHistoryDTO settlementObjectionHistory,
                                      RefundingHistoryDTO refundingHistory, String changedReason, String changedDate,
                                      int changedAmount) {
        this.settlementChangeHistoryNo = settlementChangeHistoryNo;
        this.settlementInfo = settlementInfo;
        this.settlementChangedCategory = settlementChangedCategory;
        this.settlementObjectionHistory = settlementObjectionHistory;
        this.refundingHistory = refundingHistory;
        this.changedReason = changedReason;
        this.changedDate = changedDate;
        this.changedAmount = changedAmount;
    }

    public int getSettlementChangeHistoryNo() {
        return settlementChangeHistoryNo;
    }

    public void setSettlementChangeHistoryNo(int settlementChangeHistoryNo) {
        this.settlementChangeHistoryNo = settlementChangeHistoryNo;
    }

    public SettlementInfoDTO getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfoDTO settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public SettlementChangedCategoryDTO getSettlementChangedCategory() {
        return settlementChangedCategory;
    }

    public void setSettlementChangedCategory(SettlementChangedCategoryDTO settlementChangedCategory) {
        this.settlementChangedCategory = settlementChangedCategory;
    }

    public SettlementObjectionHistoryDTO getSettlementObjectionHistory() {
        return settlementObjectionHistory;
    }

    public void setSettlementObjectionHistory(SettlementObjectionHistoryDTO settlementObjectionHistory) {
        this.settlementObjectionHistory = settlementObjectionHistory;
    }

    public RefundingHistoryDTO getRefundingHistory() {
        return refundingHistory;
    }

    public void setRefundingHistory(RefundingHistoryDTO refundingHistory) {
        this.refundingHistory = refundingHistory;
    }

    public String getChangedReason() {
        return changedReason;
    }

    public void setChangedReason(String changedReason) {
        this.changedReason = changedReason;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public int getChangedAmount() {
        return changedAmount;
    }

    public void setChangedAmount(int changedAmount) {
        this.changedAmount = changedAmount;
    }

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
