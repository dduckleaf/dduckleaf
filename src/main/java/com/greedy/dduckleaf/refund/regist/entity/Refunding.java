package com.greedy.dduckleaf.refund.regist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundingForRegist")
@Table(name = "TBL_REFUNDING")
public class Refunding {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;

    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;

    @Column(name = "REFUNDING_REASON")
    private String refundingReason;

    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;

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

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;



}
