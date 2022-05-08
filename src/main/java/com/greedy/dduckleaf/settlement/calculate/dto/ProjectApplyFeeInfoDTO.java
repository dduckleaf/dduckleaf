package com.greedy.dduckleaf.settlement.calculate.dto;
import com.greedy.dduckleaf.settlement.calculate.entity.FeePolicy;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectApplyFeeInfoDTO {

    private int projectApplyFeeInfoNo;
    private int projectNo;
    private FeePolicyDTO feePolicy;

    @Override
    public String toString() {
        return "ProjectApplyFeeInfoDTO{" +
                "projectApplyFeeInfoNo=" + projectApplyFeeInfoNo +
                ", projectNo=" + projectNo +
                ", feePolicy=" + feePolicy +
                '}';
    }
}
