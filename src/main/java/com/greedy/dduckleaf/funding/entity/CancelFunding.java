package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

@Entity(name = "CancelFundingForFunding")
@Table(name = "TBL_CANCEL_FUNDING")
public class CancelFunding {
    @Id
    @Column(name = "CANCEL_FUNDING_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancelFundingNo;

    @Column(name = "CANCEL_FUNDING_CATEGORY_NO")
    private int cancelFundingCategoryNo;

    @Column(name = "CANCEL_FUNDING_CONTENT")
    private String cancelFundingContent;

    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

}
