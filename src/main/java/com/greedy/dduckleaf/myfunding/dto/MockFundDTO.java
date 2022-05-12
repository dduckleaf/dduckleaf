package com.greedy.dduckleaf.myfunding.dto;

import java.sql.Date;

public class MockFundDTO {

    private int mockFundNo;
    private String mockFundName;
    private java.sql.Date openDate;
    private java.sql.Date endDate;
    private String mockFundStatus;
    private java.sql.Date canceledDate;
    private int targetTicketAmount;
    private String mockFundProgressStatus;
    private String examineResult;
    private int farmerNo;

    public MockFundDTO() {
    }

    public MockFundDTO(int mockFundNo, String mockFundName, Date openDate, Date endDate, String mockFundStatus, Date canceledDate, int targetTicketAmount, String mockFundProgressStatus, String examineResult, int farmerNo) {
        this.mockFundNo = mockFundNo;
        this.mockFundName = mockFundName;
        this.openDate = openDate;
        this.endDate = endDate;
        this.mockFundStatus = mockFundStatus;
        this.canceledDate = canceledDate;
        this.targetTicketAmount = targetTicketAmount;
        this.mockFundProgressStatus = mockFundProgressStatus;
        this.examineResult = examineResult;
        this.farmerNo = farmerNo;
    }

    public int getMockFundNo() {
        return mockFundNo;
    }

    public void setMockFundNo(int mockFundNo) {
        this.mockFundNo = mockFundNo;
    }

    public String getMockFundName() {
        return mockFundName;
    }

    public void setMockFundName(String mockFundName) {
        this.mockFundName = mockFundName;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMockFundStatus() {
        return mockFundStatus;
    }

    public void setMockFundStatus(String mockFundStatus) {
        this.mockFundStatus = mockFundStatus;
    }

    public Date getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(Date canceledDate) {
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

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    @Override
    public String toString() {
        return "MockFundDTO{" +
                "mockFundNo=" + mockFundNo +
                ", mockFundName='" + mockFundName + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                ", mockFundStatus='" + mockFundStatus + '\'' +
                ", canceledDate=" + canceledDate +
                ", targetTicketAmount=" + targetTicketAmount +
                ", mockFundProgressStatus='" + mockFundProgressStatus + '\'' +
                ", examineResult='" + examineResult + '\'' +
                ", farmerNo=" + farmerNo +
                '}';
    }
}
