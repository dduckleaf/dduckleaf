package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementObjectionHistoryDTO {

    private int settlementObjectionHistoryNo;                   //이의신청처리이력번호
    private String settlementObjectionHandleStatus;             //처리상태
    private String settlementObjectionHandleDate;               //상태변경일
    private SettlementObjectionInfoDTO settlementObjectionInfo; //이의신청내역
    private List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList;
    private List<SettlementChangeHistoryDTO> settlementChangeHistoryList;

    public SettlementObjectionHistoryDTO() {}

    public SettlementObjectionHistoryDTO(int settlementObjectionHistoryNo, String settlementObjectionHandleStatus,
                                         String settlementObjectionHandleDate, SettlementObjectionInfoDTO settlementObjectionInfo,
                                         List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList,
                                         List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.settlementObjectionHistoryNo = settlementObjectionHistoryNo;
        this.settlementObjectionHandleStatus = settlementObjectionHandleStatus;
        this.settlementObjectionHandleDate = settlementObjectionHandleDate;
        this.settlementObjectionInfo = settlementObjectionInfo;
        this.settlementPaymentHistoryList = settlementPaymentHistoryList;
        this.settlementChangeHistoryList = settlementChangeHistoryList;
    }

    public int getSettlementObjectionHistoryNo() {
        return settlementObjectionHistoryNo;
    }

    public void setSettlementObjectionHistoryNo(int settlementObjectionHistoryNo) {
        this.settlementObjectionHistoryNo = settlementObjectionHistoryNo;
    }

    public String getSettlementObjectionHandleStatus() {
        return settlementObjectionHandleStatus;
    }

    public void setSettlementObjectionHandleStatus(String settlementObjectionHandleStatus) {
        this.settlementObjectionHandleStatus = settlementObjectionHandleStatus;
    }

    public String getSettlementObjectionHandleDate() {
        return settlementObjectionHandleDate;
    }

    public void setSettlementObjectionHandleDate(String settlementObjectionHandleDate) {
        this.settlementObjectionHandleDate = settlementObjectionHandleDate;
    }

    public SettlementObjectionInfoDTO getSettlementObjectionInfo() {
        return settlementObjectionInfo;
    }

    public void setSettlementObjectionInfo(SettlementObjectionInfoDTO settlementObjectionInfo) {
        this.settlementObjectionInfo = settlementObjectionInfo;
    }

    public List<SettlementPaymentHistoryDTO> getSettlementPaymentHistoryList() {
        return settlementPaymentHistoryList;
    }

    public void setSettlementPaymentHistoryList(List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList) {
        this.settlementPaymentHistoryList = settlementPaymentHistoryList;
    }

    public List<SettlementChangeHistoryDTO> getSettlementChangeHistoryList() {
        return settlementChangeHistoryList;
    }

    public void setSettlementChangeHistoryList(List<SettlementChangeHistoryDTO> settlementChangeHistoryList) {
        this.settlementChangeHistoryList = settlementChangeHistoryList;
    }

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
