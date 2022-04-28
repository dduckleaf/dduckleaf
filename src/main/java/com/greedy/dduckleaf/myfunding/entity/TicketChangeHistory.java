package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
}
