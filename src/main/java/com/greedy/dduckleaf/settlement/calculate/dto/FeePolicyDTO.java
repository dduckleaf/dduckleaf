package com.greedy.dduckleaf.settlement.calculate.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FeePolicyDTO {

    private int feePolicyRateNo;                //수수료정책번호
    private int feeApplyRate;                   //적용수수료율
    private String feeCategory;                 //수수료 구분

    @Override
    public String toString() {
        return "FeePolicyDTO{" +
                "feePolicyRateNo=" + feePolicyRateNo +
                ", feeApplyRate=" + feeApplyRate +
                ", feeCategory='" + feeCategory + '\'' +
                '}';
    }
}
