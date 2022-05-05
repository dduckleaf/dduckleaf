package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
}
