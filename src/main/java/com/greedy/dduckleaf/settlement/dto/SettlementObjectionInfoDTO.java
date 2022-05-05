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
public class SettlementObjectionInfoDTO {

    private int settlementObjectionInfoNo;                          //이의신청번호
    private String settlementObjectionContent;                      //이의신청내용
    private SettlementPaymentHistoryDTO settlementPaymentHistory;      //지급이력
    private List<SettlementObjectionHistoryDTO> settlementObjectionHistoryList;

    @Override
    public String toString() {
        return "SettlementObjectionInfo{" +
                "settlementObjectionInfoNo=" + settlementObjectionInfoNo +
                ", settlementPaymentHistory=" + settlementPaymentHistory +
                ", settlementObjectionContent='" + settlementObjectionContent + '\'' +
                '}';
    }
}
