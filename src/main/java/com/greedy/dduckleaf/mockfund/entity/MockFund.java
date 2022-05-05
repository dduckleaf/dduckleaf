package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MockFund")
@Table(name = "TBL_MOCK_FUND")
public class MockFund {

    @Id
    @Column(name = "MOCK_FUND_NO")
    private int mockFundNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FARMER_NO")
    private Farmer farmer;

    @Column(name = "MOCK_FUND_NAME")
    private String mockFundName;

    @Column(name = "OPEN_DATE")
    private String openDate;

    @Column(name = "END_DATE")
    private String closeDate;

    @Column(name = "MOCK_FUND_STATUS")
    private String mockFundStatus;

    @Column(name = "CANCELED_DATE")
    private String canceledDate;

    @Column(name = "TARGET_TICKET_AMOUNT")
    private int targetTicketAmount;

    @Column(name = "MOCK_FUND_PROGRESS_STATUS")
    private String mockFundProgressStatus;

    @Column(name = "EXAMINE_RESULT")
    private String examineResult;

    @OneToMany(mappedBy = "mockFund")
    private List<MockFundInfo> mockFundInfoList;

    @OneToMany(mappedBy = "mockFund")
    private List<MockFundReward> mockFundRewardList;

    public MockFund() {}

    public MockFund(int mockFundNo, Farmer farmer, String mockFundName, String openDate, String closeDate, String mockFundStatus, String canceledDate, int targetTicketAmount, String mockFundProgressStatus, String examineResult, List<MockFundInfo> mockFundInfoList, List<MockFundReward> mockFundRewardList) {
        this.mockFundNo = mockFundNo;
        this.farmer = farmer;
        this.mockFundName = mockFundName;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.mockFundStatus = mockFundStatus;
        this.canceledDate = canceledDate;
        this.targetTicketAmount = targetTicketAmount;
        this.mockFundProgressStatus = mockFundProgressStatus;
        this.examineResult = examineResult;
        this.mockFundInfoList = mockFundInfoList;
        this.mockFundRewardList = mockFundRewardList;
    }

    public int getMockFundNo() {
        return mockFundNo;
    }

    public void setMockFundNo(int mockFundNo) {
        this.mockFundNo = mockFundNo;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public String getMockFundName() {
        return mockFundName;
    }

    public void setMockFundName(String mockFundName) {
        this.mockFundName = mockFundName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getMockFundStatus() {
        return mockFundStatus;
    }

    public void setMockFundStatus(String mockFundStatus) {
        this.mockFundStatus = mockFundStatus;
    }

    public String getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(String canceledDate) {
        this.canceledDate = canceledDate;
    }

    public int getTargetTicketAmount() {
        return targetTicketAmount;
    }

    public void setTargetTicketAmount(int targetTicketAmount) {
        this.targetTicketAmount = targetTicketAmount;
    }

    public String getMockFundProgressStatus() {
        return mockFundProgressStatus;
    }

    public void setMockFundProgressStatus(String mockFundProgressStatus) {
        this.mockFundProgressStatus = mockFundProgressStatus;
    }

    public String getExamineResult() {
        return examineResult;
    }

    public void setExamineResult(String examineResult) {
        this.examineResult = examineResult;
    }

    public List<MockFundInfo> getMockFundInfoList() {
        return mockFundInfoList;
    }

    public void setMockFundInfoList(List<MockFundInfo> mockFundInfoList) {
        this.mockFundInfoList = mockFundInfoList;
    }

    public List<MockFundReward> getMockFundRewardList() {
        return mockFundRewardList;
    }

    public void setMockFundRewardList(List<MockFundReward> mockFundRewardList) {
        this.mockFundRewardList = mockFundRewardList;
    }

    @Override
    public String toString() {
        return "MockFund{" +
                "mockFundNo=" + mockFundNo +
                ", farmer=" + farmer +
                ", mockFundName='" + mockFundName + '\'' +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", mockFundStatus='" + mockFundStatus + '\'' +
                ", canceledDate=" + canceledDate +
                ", targetTicketAmount=" + targetTicketAmount +
                ", mockFundProgressStatus='" + mockFundProgressStatus + '\'' +
                ", examineResult='" + examineResult + '\'' +
                '}';
    }
}
