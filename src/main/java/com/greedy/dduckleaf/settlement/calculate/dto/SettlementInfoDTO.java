package com.greedy.dduckleaf.settlement.calculate.dto;

import com.greedy.dduckleaf.settlement.calculate.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String calculateDate;                       //정산금 계산일
    private ProjectDTOForJson project;                         //프로젝트 번호

    @Override
    public String toString() {
        return "SettlementInfoDTO{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", calculateDate='" + calculateDate + '\'' +
                ", project=" + project +
                '}';
    }
}
