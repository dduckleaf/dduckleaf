package com.greedy.dduckleaf.settlement.dto;

import com.greedy.dduckleaf.settlement.calculate.dto.SettlementPaymentStandardDTO;

import java.util.List;

public class SettlementPaymentInfoDTO {

    private int settlementPaymentInfoNo;                            //회차별정산금지급내역번호
    private int settlementPaymentAmount;                            //지급금액
    private String farmerSettlementCheckStatus;                     //파머 확인여부
    private String settlementPaymentDate;                           //지급일
    private SettlementInfoDTO settlementInfo;                       //정산정보
    private String settlementPaymentStatus;                         //지급상태
    private SettlementPaymentStandardDTO settlementPaymentStandard;    //정산금지급기준
    private List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList;

    public SettlementPaymentInfoDTO() {}

    public SettlementPaymentInfoDTO(int settlementPaymentInfoNo, int settlementPaymentAmount,
                                    String farmerSettlementCheckStatus, String settlementPaymentDate,
                                    SettlementInfoDTO settlementInfo, String settlementPaymentStatus,
                                    SettlementPaymentStandardDTO settlementPaymentStandard,
                                    List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList) {
        this.settlementPaymentInfoNo = settlementPaymentInfoNo;
        this.settlementPaymentAmount = settlementPaymentAmount;
        this.farmerSettlementCheckStatus = farmerSettlementCheckStatus;
        this.settlementPaymentDate = settlementPaymentDate;
        this.settlementInfo = settlementInfo;
        this.settlementPaymentStatus = settlementPaymentStatus;
        this.settlementPaymentStandard = settlementPaymentStandard;
        this.settlementPaymentHistoryList = settlementPaymentHistoryList;
    }

    public int getSettlementPaymentInfoNo() {
        return settlementPaymentInfoNo;
    }

    public void setSettlementPaymentInfoNo(int settlementPaymentInfoNo) {
        this.settlementPaymentInfoNo = settlementPaymentInfoNo;
    }

    public int getSettlementPaymentAmount() {
        return settlementPaymentAmount;
    }

    public void setSettlementPaymentAmount(int settlementPaymentAmount) {
        this.settlementPaymentAmount = settlementPaymentAmount;
    }

    public String getFarmerSettlementCheckStatus() {
        return farmerSettlementCheckStatus;
    }

    public void setFarmerSettlementCheckStatus(String farmerSettlementCheckStatus) {
        this.farmerSettlementCheckStatus = farmerSettlementCheckStatus;
    }

    public String getSettlementPaymentDate() {
        return settlementPaymentDate;
    }

    public void setSettlementPaymentDate(String settlementPaymentDate) {
        this.settlementPaymentDate = settlementPaymentDate;
    }

    public SettlementInfoDTO getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfoDTO settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public String getSettlementPaymentStatus() {
        return settlementPaymentStatus;
    }

    public void setSettlementPaymentStatus(String settlementPaymentStatus) {
        this.settlementPaymentStatus = settlementPaymentStatus;
    }

    public SettlementPaymentStandardDTO getSettlementPaymentStandard() {
        return settlementPaymentStandard;
    }

    public void setSettlementPaymentStandard(SettlementPaymentStandardDTO settlementPaymentStandard) {
        this.settlementPaymentStandard = settlementPaymentStandard;
    }

    public List<SettlementPaymentHistoryDTO> getSettlementPaymentHistoryList() {
        return settlementPaymentHistoryList;
    }

    public void setSettlementPaymentHistoryList(List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList) {
        this.settlementPaymentHistoryList = settlementPaymentHistoryList;
    }

    @Override
    public String toString() {
        return "SettlementPaymentInfo{" +
                "settlementPaymentInfoNo=" + settlementPaymentInfoNo +
                ", settlementPaymentAmount=" + settlementPaymentAmount +
                ", farmerSettlementCheckStatus='" + farmerSettlementCheckStatus + '\'' +
                ", settlementPaymentDate='" + settlementPaymentDate + '\'' +
                ", settlementInfo=" + settlementInfo +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentStandard=" + settlementPaymentStandard +
                '}';
    }
}
