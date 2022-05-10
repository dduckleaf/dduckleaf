package com.greedy.dduckleaf.refund.find.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundingCountForAdminFind")
@Table(name = "TBL_REFUNDING")
public class RefundingCount {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_CATEGORY_NO")
    private RefundingCategory refundingCategory;

    @Column(name = "REFUNDING_REASON")
    private String refundingReason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_STATUS_NO")
    private RefundingStatus refundingStatus;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REFUNDING_ACCOUNT")
    private String refundingAccount;

    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "REFUNDING_MEMBER_NAME")
    private String refundingMemberName;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;
}
