package com.greedy.dduckleaf.funding.entity;

import com.greedy.dduckleaf.refund.find.entity.Funding;
import com.greedy.dduckleaf.refund.find.entity.Project;
import com.greedy.dduckleaf.refund.find.entity.RefundingCategory;
import com.greedy.dduckleaf.refund.find.entity.RefundingStatus;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundingForAdminFundingFindList")
@Table(name = "TBL_REFUNDING")
public class Refunding {

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Column(name = "REFUNDING_ACCOUNT")
    private String refundingAccount;

    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "REFUNDING_MEMBER_NAME")
    private String refundingMemberName;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;
}