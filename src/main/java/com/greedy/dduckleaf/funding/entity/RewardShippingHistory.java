package com.greedy.dduckleaf.funding.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "HistoryForFunding")
@Table(name = "TBL_REWARD_SHIPPING_HISTORY")
public class RewardShippingHistory {

    @Id
    @Column(name = "REWARD_SHIPPING_HISTORY_NO")
    private int rewardShippingHistoryNo;

    @Column(name = "SHIPPING_STATUS")
    private int shippingStatus;

    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "RECORD_DATE")
    private String recordDate;

    public RewardShippingHistory() {
    }

    public RewardShippingHistory(int rewardShippingHistoryNo, int shippingStatus, int rewardShippingNo, String recordDate) {
        this.rewardShippingHistoryNo = rewardShippingHistoryNo;
        this.shippingStatus = shippingStatus;
        this.rewardShippingNo = rewardShippingNo;
        this.recordDate = recordDate;
    }

    public int getRewardShippingHistoryNo() {
        return rewardShippingHistoryNo;
    }

    public void setRewardShippingHistoryNo(int rewardShippingHistoryNo) {
        this.rewardShippingHistoryNo = rewardShippingHistoryNo;
    }

    public int getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(int shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public int getRewardShippingNo() {
        return rewardShippingNo;
    }

    public void setRewardShippingNo(int rewardShippingNo) {
        this.rewardShippingNo = rewardShippingNo;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "RewardShippingHistory{" +
                "rewardShippingHistoryNo=" + rewardShippingHistoryNo +
                ", shippingStatus=" + shippingStatus +
                ", rewardShippingNo=" + rewardShippingNo +
                ", recordDate='" + recordDate + '\'' +
                '}';
    }
}
