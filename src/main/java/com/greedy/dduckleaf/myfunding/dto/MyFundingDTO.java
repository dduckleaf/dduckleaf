package com.greedy.dduckleaf.myfunding.dto;

public class MyFundingDTO {

    private int fundingTimes;
    private int mockFundingTimes;
    private int ticketAmount;

    public MyFundingDTO() {
    }

    public MyFundingDTO(int fundingTimes, int mockFundingTimes, int ticketAmount) {
        this.fundingTimes = fundingTimes;
        this.mockFundingTimes = mockFundingTimes;
        this.ticketAmount = ticketAmount;
    }

    public int getFundingTimes() {
        return fundingTimes;
    }

    public void setFundingTimes(int fundingTimes) {
        this.fundingTimes = fundingTimes;
    }

    public int getMockFundingTimes() {
        return mockFundingTimes;
    }

    public void setMockFundingTimes(int mockFundingTimes) {
        this.mockFundingTimes = mockFundingTimes;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    @Override
    public String toString() {
        return "MyFundingDTO{" +
                "fundingTimes=" + fundingTimes +
                ", mockFundingTimes=" + mockFundingTimes +
                ", ticketAmount=" + ticketAmount +
                '}';
    }
}
