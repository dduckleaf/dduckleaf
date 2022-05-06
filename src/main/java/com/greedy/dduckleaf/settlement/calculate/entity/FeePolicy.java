package com.greedy.dduckleaf.settlement.calculate.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FeePolicyForSettlementCalculate")
@Table(name = "TBL_FEE_POLICY")
public class FeePolicy {

    @Id
    @Column(name = "FEE_POLICY_RATE_NO")
    private int feePolicyRateNo;                //수수료정책번호

    @Column(name = "FEE_APPLY_RATE")
    private int feeApplyRate;                   //적용수수료율

    @Column(name = "FEE_POLICY_STATUS")
    private String feePolicyStatus;             //활성화여부

    @Column(name = "FEE_POLICY_EXPIRE_DATE")
    private String feePolicyExpireDate;         //만료일

    @Column(name = "FEE_POLICY_START_DATE")
    private String feePolicyStartDate;          //정책적용시작일

    @Column(name = "FEE_POLICY_REGIST_DATE")
    private String feePolicyRegistDate;         //등록일

    @Column(name = "FEE_CATEGORY")
    private String feeCategory;                 //수수료 구분

    @Override
    public String toString() {
        return "FeePolicy{" +
                "feePolicyRateNo=" + feePolicyRateNo +
                ", feeApplyRate=" + feeApplyRate +
                ", feePolicyStatus='" + feePolicyStatus + '\'' +
                ", feePolicyExpireDate='" + feePolicyExpireDate + '\'' +
                ", feePolicyStartDate='" + feePolicyStartDate + '\'' +
                ", feePolicyRegistDate='" + feePolicyRegistDate + '\'' +
                ", feeCategory='" + feeCategory + '\'' +
                '}';
    }
}
