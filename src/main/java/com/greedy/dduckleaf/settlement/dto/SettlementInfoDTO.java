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
public class SettlementInfoDTO {

    private int settlementInfoNo;                       //정산정보번호
    private int fundingTotalAmount;                     //펀딩금총액
    private int donateAmount;                           //후원금총액
    private int settlementTotalAmount;                  //정산금총액
    private int totalCommissionAmount;                  //수수료총액
    private ProjectDTO project;                         //프로젝트번호
    private List<SettlementPaymentInfoDTO> settlementPaymentInfoList;
    private List<SettlementChangeHistoryDTO> settlementChangeHistoryList;

    @Override
    public String toString() {
        return "SettlementInfo{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
//                ", project=" + project +
                '}';
    }
}
