package com.greedy.dduckleaf.settlement.check.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FeePolicyForFarmerCheck")
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

    public FeePolicy() {}

    public FeePolicy(int feePolicyRateNo, int feeApplyRate, String feePolicyStatus, String feePolicyExpireDate,
                     String feePolicyStartDate, String feePolicyRegistDate, String feeCategory) {
        this.feePolicyRateNo = feePolicyRateNo;
        this.feeApplyRate = feeApplyRate;
        this.feePolicyStatus = feePolicyStatus;
        this.feePolicyExpireDate = feePolicyExpireDate;
        this.feePolicyStartDate = feePolicyStartDate;
        this.feePolicyRegistDate = feePolicyRegistDate;
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

    public String getFeePolicyStatus() {
        return feePolicyStatus;
    }

    public void setFeePolicyStatus(String feePolicyStatus) {
        this.feePolicyStatus = feePolicyStatus;
    }

    public String getFeePolicyExpireDate() {
        return feePolicyExpireDate;
    }

    public void setFeePolicyExpireDate(String feePolicyExpireDate) {
        this.feePolicyExpireDate = feePolicyExpireDate;
    }

    public String getFeePolicyStartDate() {
        return feePolicyStartDate;
    }

    public void setFeePolicyStartDate(String feePolicyStartDate) {
        this.feePolicyStartDate = feePolicyStartDate;
    }

    public String getFeePolicyRegistDate() {
        return feePolicyRegistDate;
    }

    public void setFeePolicyRegistDate(String feePolicyRegistDate) {
        this.feePolicyRegistDate = feePolicyRegistDate;
    }

    public String getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(String feeCategory) {
        this.feeCategory = feeCategory;
    }

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
