package com.greedy.dduckleaf.settlement.check.dto;

public class FeePolicyDTO {

    private int feePolicyRateNo;                //수수료정책번호
    private int feeApplyRate;                   //적용수수료율
    private String feeCategory;                 //수수료 구분

    public FeePolicyDTO() {}

    public FeePolicyDTO(int feePolicyRateNo, int feeApplyRate, String feeCategory) {
        this.feePolicyRateNo = feePolicyRateNo;
        this.feeApplyRate = feeApplyRate;
        this.feeCategory = feeCategory;
    }

    public int getFeePolicyRateNo() {
        return feePolicyRateNo;
    }

    public void setFeePolicyRateNo(int feePolicyRateNo) {
        this.feePolicyRateNo = feePolicyRateNo;
    }

    public int getFeeApplyRate() {
        return feeApplyRate;
    }

    public void setFeeApplyRate(int feeApplyRate) {
        this.feeApplyRate = feeApplyRate;
    }

    public String getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(String feeCategory) {
        this.feeCategory = feeCategory;
    }

    @Override
    public String toString() {
        return "FeePolicyDTO{" +
                "feePolicyRateNo=" + feePolicyRateNo +
                ", feeApplyRate=" + feeApplyRate +
                ", feeCategory='" + feeCategory + '\'' +
                '}';
    }
}
