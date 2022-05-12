package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementObjectionInfoDTO {

    private int settlementObjectionInfoNo;                          //이의신청번호
    private String settlementObjectionContent;                      //이의신청내용
    private SettlementPaymentHistoryDTO settlementPaymentHistory;      //지급이력
    private List<SettlementObjectionHistoryDTO> settlementObjectionHistoryList;

    public SettlementObjectionInfoDTO() {}

    public SettlementObjectionInfoDTO(int settlementObjectionInfoNo, String settlementObjectionContent,
                                      SettlementPaymentHistoryDTO settlementPaymentHistory,
                                      List<SettlementObjectionHistoryDTO> settlementObjectionHistoryList) {
        this.settlementObjectionInfoNo = settlementObjectionInfoNo;
        this.settlementObjectionContent = settlementObjectionContent;
        this.settlementPaymentHistory = settlementPaymentHistory;
        this.settlementObjectionHistoryList = settlementObjectionHistoryList;
    }

    public int getSettlementObjectionInfoNo() {
        return settlementObjectionInfoNo;
    }

    public void setSettlementObjectionInfoNo(int settlementObjectionInfoNo) {
        this.settlementObjectionInfoNo = settlementObjectionInfoNo;
    }

    public String getSettlementObjectionContent() {
        return settlementObjectionContent;
    }

    public void setSettlementObjectionContent(String settlementObjectionContent) {
        this.settlementObjectionContent = settlementObjectionContent;
    }

    public SettlementPaymentHistoryDTO getSettlementPaymentHistory() {
        return settlementPaymentHistory;
    }

    public void setSettlementPaymentHistory(SettlementPaymentHistoryDTO settlementPaymentHistory) {
        this.settlementPaymentHistory = settlementPaymentHistory;
    }

    public List<SettlementObjectionHistoryDTO> getSettlementObjectionHistoryList() {
        return settlementObjectionHistoryList;
    }

    public void setSettlementObjectionHistoryList(List<SettlementObjectionHistoryDTO> settlementObjectionHistoryList) {
        this.settlementObjectionHistoryList = settlementObjectionHistoryList;
    }

    @Override
    public String toString() {
        return "SettlementObjectionInfo{" +
                "settlementObjectionInfoNo=" + settlementObjectionInfoNo +
                ", settlementPaymentHistory=" + settlementPaymentHistory +
                ", settlementObjectionContent='" + settlementObjectionContent + '\'' +
                '}';
    }
}
