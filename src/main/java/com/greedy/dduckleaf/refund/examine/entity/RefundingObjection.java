package com.greedy.dduckleaf.refund.examine.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundObjection")
@Table(name = "TBL_REFUND_OBJECTION")
public class RefundingObjection {

    @Id
    @Column(name = "REFUND_OBJECTION_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refundObjectionNo;

    @Column(name = "REFUND_OBJECTRION_REASON")
    private String refundObjectionReason;

    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUND_OBJECTION_MEMBER_NO")
    private int refundObjectionMemberNo;

    @Column(name = "REFUND_STUATUS")
    private String refundStatus;
}
