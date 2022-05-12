package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

@Entity(name = "TicketChangeHistoryForMyFunding")
@Table(name = "TBL_TICKET_CHANGE_HISTORY")
public class TicketChangeHistory {

    @Id
    @Column(name = "TICKET_CHANGE_HISTORY_NO")
    private int ticketChangeHistoryNo;

    @Column(name = "TICKET_AMOUNT")
    private int ticketAmount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    public TicketChangeHistory() {
    }

    public TicketChangeHistory(int ticketChangeHistoryNo, int ticketAmount, Member member) {
        this.ticketChangeHistoryNo = ticketChangeHistoryNo;
        this.ticketAmount = ticketAmount;
        this.member = member;
    }

    public int getTicketChangeHistoryNo() {
        return ticketChangeHistoryNo;
    }

    public void setTicketChangeHistoryNo(int ticketChangeHistoryNo) {
        this.ticketChangeHistoryNo = ticketChangeHistoryNo;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "TicketChangeHistory{" +
                "ticketChangeHistoryNo=" + ticketChangeHistoryNo +
                ", ticketAmount=" + ticketAmount +
                ", member=" + member +
                '}';
    }
}
