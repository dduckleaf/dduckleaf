package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementInfo")
@Table(name = "TBL_SETTLEMENT_INFO")
public class SettlementInfo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementInfoNo;                       //정산정보번호

    @Column(name = "FUNDING_TOTAL_AMOUNT")
    private int fundingTotalAmount;                     //펀딩금총액

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;                           //후원금총액

    @Column(name = "SETTLEMENT_TOTAL_AMOUNT")
    private int settlementTotalAmount;                  //정산금총액

    @Column(name = "TOTAL_COMMISSION")
    private int totalCommissionAmount;                  //수수료총액

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                                    //프로젝트번호

    @OneToMany(mappedBy = "settlementInfo")
    private List<SettlementPaymentInfo> settlementPaymentInfoList;

    @OneToMany(mappedBy = "settlementInfo")
    private List<SettlementChangeHistory> settlementChangeHistoryList;

    @Override
    public String toString() {
        return "SettlementInfo{" +
                "settlementInfoNo=" + settlementInfoNo +
                ", fundingTotalAmount=" + fundingTotalAmount +
                ", donateAmount=" + donateAmount +
                ", settlementTotalAmount=" + settlementTotalAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", project=" + project +
                '}';
    }
}
