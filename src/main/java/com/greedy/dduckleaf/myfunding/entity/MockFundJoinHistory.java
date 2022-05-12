package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

@Entity(name = "MockFundJoinHistoryForMyFunding")
@Table(name = "TBL_MOCK_FUND_JOIN_HISTORY")
public class MockFundJoinHistory {

    @Id
    @Column(name = "MOCK_FUND_JOIN_HISTORY_NO")
    private int mockFundJoinHistoryNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MOCK_FUND_NO")
    private MockFund mockFund;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @Column(name = "TICKET_AMOUNT")
    private int ticketAmount;

    public MockFundJoinHistory() {
    }

    public MockFundJoinHistory(int mockFundJoinHistoryNo, MockFund mockFund, Member member, int ticketAmount) {
        this.mockFundJoinHistoryNo = mockFundJoinHistoryNo;
        this.mockFund = mockFund;
        this.member = member;
        this.ticketAmount = ticketAmount;
    }

    public int getMockFundJoinHistoryNo() {
        return mockFundJoinHistoryNo;
    }

    public void setMockFundJoinHistoryNo(int mockFundJoinHistoryNo) {
        this.mockFundJoinHistoryNo = mockFundJoinHistoryNo;
    }

    public MockFund getMockFund() {
        return mockFund;
    }

    public void setMockFund(MockFund mockFund) {
        this.mockFund = mockFund;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    @Override
    public String toString() {
        return "MockFundJoinHistory{" +
                "mockFundJoinHistoryNo=" + mockFundJoinHistoryNo +
                ", mockFund=" + mockFund +
                ", member=" + member +
                ", ticketAmount=" + ticketAmount +
                '}';
    }
}
