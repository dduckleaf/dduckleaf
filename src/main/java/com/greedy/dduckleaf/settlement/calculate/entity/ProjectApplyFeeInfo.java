package com.greedy.dduckleaf.settlement.calculate.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectApplyFeeInfoForSettlementCalculate")
@Table(name = "TBL_PROJECT_APPLY_FEE_INFO")
public class ProjectApplyFeeInfo {

    @Id
    @Column(name = "PROJECT_APPLY_FEE_INFO_NO")
    private int projectApplyFeeInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FEE_POLICY_RATE_NO")
    private FeePolicy feePolicy;

    @Override
    public String toString() {
        return "ProjectApplyFeeInfo{" +
                "projectApplyFeeInfoNo=" + projectApplyFeeInfoNo +
                ", projectNo=" + projectNo +
                ", feePolicy=" + feePolicy +
                '}';
    }
}
