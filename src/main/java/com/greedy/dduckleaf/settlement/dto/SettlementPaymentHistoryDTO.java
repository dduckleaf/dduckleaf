package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementPaymentHistoryDTO {

    private int settlementPaymentHistoryNo;                                     //지급이력번호
    private String settlementStatus;                                            //지급상태
    private String settlementPaymentHistoryDate;                                //상태변경일
    private String settlementPaymentHistoryCategory;                            //정산금 지급 이력 구분
    private SettlementPaymentInfoDTO settlementPaymentInfo;                        //회차별정산금지급내역번호
    private SettlementObjectionHistoryDTO settlementObjectionHistory;           //이의신청처리이력번호
    private List<SettlementObjectionInfoDTO> settlementObjectionInfoList;

    public SettlementPaymentHistoryDTO() {}

    public SettlementPaymentHistoryDTO(int settlementPaymentHistoryNo, String settlementStatus,
                                       String settlementPaymentHistoryDate, String settlementPaymentHistoryCategory,
                                       SettlementPaymentInfoDTO settlementPaymentInfo,
                                       SettlementObjectionHistoryDTO settlementObjectionHistory,
                                       List<SettlementObjectionInfoDTO> settlementObjectionInfoList) {
        this.settlementPaymentHistoryNo = settlementPaymentHistoryNo;
        this.settlementStatus = settlementStatus;
        this.settlementPaymentHistoryDate = settlementPaymentHistoryDate;
        this.settlementPaymentHistoryCategory = settlementPaymentHistoryCategory;
        this.settlementPaymentInfo = settlementPaymentInfo;
        this.settlementObjectionHistory = settlementObjectionHistory;
        this.settlementObjectionInfoList = settlementObjectionInfoList;
    }

    public int getSettlementPaymentHistoryNo() {
        return settlementPaymentHistoryNo;
    }

    public void setSettlementPaymentHistoryNo(int settlementPaymentHistoryNo) {
        this.settlementPaymentHistoryNo = settlementPaymentHistoryNo;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getSettlementPaymentHistoryDate() {
        return settlementPaymentHistoryDate;
    }

    public void setSettlementPaymentHistoryDate(String settlementPaymentHistoryDate) {
        this.settlementPaymentHistoryDate = settlementPaymentHistoryDate;
    }

    public String getSettlementPaymentHistoryCategory() {
        return settlementPaymentHistoryCategory;
    }

    public void setSettlementPaymentHistoryCategory(String settlementPaymentHistoryCategory) {
        this.settlementPaymentHistoryCategory = settlementPaymentHistoryCategory;
    }

    public SettlementPaymentInfoDTO getSettlementPaymentInfo() {
        return settlementPaymentInfo;
    }

    public void setSettlementPaymentInfo(SettlementPaymentInfoDTO settlementPaymentInfo) {
        this.settlementPaymentInfo = settlementPaymentInfo;
    }

    public SettlementObjectionHistoryDTO getSettlementObjectionHistory() {
        return settlementObjectionHistory;
    }

    public void setSettlementObjectionHistory(SettlementObjectionHistoryDTO settlementObjectionHistory) {
        this.settlementObjectionHistory = settlementObjectionHistory;
    }

    public List<SettlementObjectionInfoDTO> getSettlementObjectionInfoList() {
        return settlementObjectionInfoList;
    }

    public void setSettlementObjectionInfoList(List<SettlementObjectionInfoDTO> settlementObjectionInfoList) {
        this.settlementObjectionInfoList = settlementObjectionInfoList;
    }

    @Override
    public String toString() {
        return "SettlementPaymentHistory{" +
                "settlementPaymentHistoryNo=" + settlementPaymentHistoryNo +
                ", settlementStatus='" + settlementStatus + '\'' +
                ", settlementPaymentHistoryDate='" + settlementPaymentHistoryDate + '\'' +
                ", settlementPaymentHistoryCategory='" + settlementPaymentHistoryCategory + '\'' +
                ", settlementPaymentInfo=" + settlementPaymentInfo +
                ", settlementObjectionHistory=" + settlementObjectionHistory +
                '}';
    }
}
