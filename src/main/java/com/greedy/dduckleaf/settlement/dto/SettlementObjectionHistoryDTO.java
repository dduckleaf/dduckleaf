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
public class SettlementObjectionHistoryDTO {

    private int settlementObjectionHistoryNo;                   //이의신청처리이력번호
    private String settlementObjectionHandleStatus;             //처리상태
    private String settlementObjectionHandleDate;               //상태변경일
    private SettlementObjectionInfoDTO settlementObjectionInfo; //이의신청내역
    private List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList;
    private List<SettlementChangeHistoryDTO> settlementChangeHistoryList;

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
