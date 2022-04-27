package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;

@Entity(name = "MockFundReward")
@Table(name = "TBL_MOCK_FUND_REWARD")
public class MockFundReward {

    @Id
    @Column(name = "MOCK_FUND_REWARD_NO")
    private int mockFundRewardNo;

    @Column(name = "REWARD_NAME")
    private String rewardName;

    @Column(name = "REWARD_DETAIL")
    private String rewardDetail;

    @Column(name = "REWARD_PRICE")
    private int rewardPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MOCK_FUND_NO")
    private MockFund mockFund;

    public MockFundReward() {}

    public MockFundReward(int mockFundRewardNo, String rewardName, String rewardDetail, int rewardPrice, MockFund mockFund) {
        this.mockFundRewardNo = mockFundRewardNo;
        this.rewardName = rewardName;
        this.rewardDetail = rewardDetail;
        this.rewardPrice = rewardPrice;
        this.mockFund = mockFund;
    }

    public int getMockFundRewardNo() {
        return mockFundRewardNo;
    }

    public void setMockFundRewardNo(int mockFundRewardNo) {
        this.mockFundRewardNo = mockFundRewardNo;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardDetail() {
        return rewardDetail;
    }

    public void setRewardDetail(String rewardDetail) {
        this.rewardDetail = rewardDetail;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(int rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public MockFund getMockFund() {
        return mockFund;
    }

    public void setMockFund(MockFund mockFund) {
        this.mockFund = mockFund;
    }

    @Override
    public String toString() {
        return "MockFundReward{" +
                "mockFundRewardNo=" + mockFundRewardNo +
                ", rewardName='" + rewardName + '\'' +
                ", rewardDetail='" + rewardDetail + '\'' +
                ", rewardPrice=" + rewardPrice +
                ", mockFund=" + mockFund +
                '}';
    }
}