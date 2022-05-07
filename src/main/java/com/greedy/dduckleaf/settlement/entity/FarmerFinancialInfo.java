package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerFinancialInfoForSettlement")
@Table(name = "TBL_FARMER_FINANCIAL_INFO")
public class FarmerFinancialInfo {

    @Id
    @Column(name = "FINANCIAL_INFO_NO")
    private int financialInfoNo;                                //파머금융정보번호

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FARMER_NO")
    private FarmerInfo farmer;                                  //파머번호

    @Column(name = "FARMER_ACCOUNT")
    private String farmerAccount;                               //계좌번호

    @Column(name = "FARMER_NAME")
    private String farmerName;                                  //예금주

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BANK_NO")
    private Bank bank;                                          //은행번호

    @Column(name = "SETTLEMENT_POLICY_CHECK_STATUS")
    private String settlementPolicyCheckStatus;                 //정산 정책 확인

    @Column(name = "SETTLEMENT_POLICY_CHECK_DATE")
    private String settlementPolicyCheckDate;                   //정산 정책 확인일

    @Override
    public String toString() {
        return "FarmerFinancialInfo{" +
                "financialInfoNo=" + financialInfoNo +
                ", farmer=" + farmer +
                ", farmerAccount='" + farmerAccount + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", bank=" + bank +
                ", settlementPolicyCheckStatus='" + settlementPolicyCheckStatus + '\'' +
                ", settlementPolicyCheckDate='" + settlementPolicyCheckDate + '\'' +
                '}';
    }
}
