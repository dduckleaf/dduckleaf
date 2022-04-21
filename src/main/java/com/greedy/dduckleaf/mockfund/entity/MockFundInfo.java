package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "MockFundInfo")
@Table(name = "TBL_MOCK_FUND_INFO")
public class MockFundInfo {

    @Id
    @Column(name = "MOCK_FUND_INFO_NO")
    private int mockFundInfoNo;

    @Column(name = "MOCK_FUND_NAME")
    private String mockFundName;

    @Column(name = "END_DATE")
    private java.sql.Date endDate;

    @Column(name = "MOCK_FUND_DETAIL")
    private String mockFundDetail;

    @Column(name = "TARGET_TICKET_AMOUNT")
    private int targetTicketAmount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MOCK_FUND_NO")
    private MockFund mockFund;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private RewardCategory rewardCategory;

    public MockFundInfo() {}

    public MockFundInfo(int mockFundInfoNo, String mockFundName, Date endDate, String mockFundDetail, int targetTicketAmount, int mockFundNo, int projectCategoryNo) {
        this.mockFundInfoNo = mockFundInfoNo;
        this.mockFundName = mockFundName;
        this.endDate = endDate;
        this.mockFundDetail = mockFundDetail;
        this.targetTicketAmount = targetTicketAmount;
        this.mockFund = mockFund;
        this.rewardCategory = rewardCategory;
    }

    public int getMockFundInfoNo() {
        return mockFundInfoNo;
    }

    public void setMockFundInfoNo(int mockFundInfoNo) {
        this.mockFundInfoNo = mockFundInfoNo;
    }

    public String getMockFundName() {
        return mockFundName;
    }

    public void setMockFundName(String mockFundName) {
        this.mockFundName = mockFundName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMockFundDetail() {
        return mockFundDetail;
    }

    public void setMockFundDetail(String mockFundDetail) {
        this.mockFundDetail = mockFundDetail;
    }

    public int getTargetTicketAmount() {
        return targetTicketAmount;
    }

    public void setTargetTicketAmount(int targetTicketAmount) {
        this.targetTicketAmount = targetTicketAmount;
    }

    public MockFund getMockFund() {
        return mockFund;
    }

    public void setMockFund(MockFund mockFund) {
        this.mockFund = mockFund;
    }

    public RewardCategory getRewardCategory() {
        return rewardCategory;
    }

    public void setRewardCategory(int projectCategoryNo) {
        this.rewardCategory = rewardCategory;
    }

    @Override
    public String toString() {
        return "MockFundInfo{" +
                "mockFundInfoNo=" + mockFundInfoNo +
                ", mockFundName='" + mockFundName + '\'' +
                ", endDate=" + endDate +
                ", mockFundDetail='" + mockFundDetail + '\'' +
                ", targetTicketAmount=" + targetTicketAmount +
                '}';
    }
}
