package com.greedy.dduckleaf.settlement.calculate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementInfoForCalculate")
@Table(name = "TBL_SETTLEMENT_INFO")
public class SettlementInfo {

    @Id
    @Column(name = "SETTLEMENT_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementInfoNo;                       //정산정보번호

    @Column(name = "FUNDING_TOTAL_AMOUNT")
    private int fundingTotalAmount;                     //펀딩금총액

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;                           //후원금총액

    @Column(name = "SETTLEMENT_TOTAL_AMOUNT")
    private int settlementTotalAmount;                  //정산금총액

    @Column(name = "TOTAL_COMMISSION_AMOUNT")
    private int totalCommissionAmount;                  //수수료총액

    @Column(name = "CALCULATE_DATE")
    private String calculateDate;                       //정산금 계산일

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO", unique = true)
    private Project project;                            //프로젝트 번호

    @Override
    public String toString() {
        return "SettlementInfo{" +
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