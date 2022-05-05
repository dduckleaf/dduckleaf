package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;

@Entity(name = "MockFundInfo")
@Table(name = "TBL_MOCK_FUND_INFO")
public class MockFundInfo {

    @Id
    @Column(name = "MOCK_FUND_INFO_NO")
    private int mockFundInfoNo;

    @Column(name = "MOCK_FUND_NAME")
    private String mockFundName;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "MOCK_FUND_DETAIL")
    private String mockFundDetail;

    @Column(name = "TARGET_TICKET_AMOUNT")
    private int targetTicketAmount;

    @Column(name = "MOCK_FUND_AGREEMENT_STATUS")
    private String mockFundAgreementStatus;

    @Column(name = "AGREEMENT_DATE")
    private String agreementDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MOCK_FUND_NO")
    private MockFund mockFund;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_CATEGORY_NO")
    private RewardCategory rewardCategory;

    public MockFundInfo() {}

    public MockFundInfo(int mockFundInfoNo, String mockFundName, String endDate, String mockFundDetail, int targetTicketAmount, String mockFundAgreementStatus, String agreementDate, MockFund mockFund, RewardCategory rewardCategory) {
        this.mockFundInfoNo = mockFundInfoNo;
        this.mockFundName = mockFundName;
        this.endDate = endDate;
        this.mockFundDetail = mockFundDetail;
        this.targetTicketAmount = targetTicketAmount;
        this.mockFundAgreementStatus = mockFundAgreementStatus;
        this.agreementDate = agreementDate;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public String getMockFundAgreementStatus() {
        return mockFundAgreementStatus;
    }

    public void setMockFundAgreementStatus(String mockFundAgreementStatus) {
        this.mockFundAgreementStatus = mockFundAgreementStatus;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
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

    public void setRewardCategory(RewardCategory rewardCategory) {
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
                ", mockFundAgreementStatus='" + mockFundAgreementStatus + '\'' +
                ", agreementDate=" + agreementDate +
                ", mockFund=" + mockFund +
                ", rewardCategory=" + rewardCategory +
                '}';
    }
}
