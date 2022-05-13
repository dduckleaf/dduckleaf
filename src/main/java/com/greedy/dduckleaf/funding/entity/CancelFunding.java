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

    public CancelFunding() {
    }

    public CancelFunding(int cancelFundingNo, int cancelFundingCategoryNo, String cancelFundingContent, int fundingInfoNo) {
        this.cancelFundingNo = cancelFundingNo;
        this.cancelFundingCategoryNo = cancelFundingCategoryNo;
        this.cancelFundingContent = cancelFundingContent;
        this.fundingInfoNo = fundingInfoNo;
    }

    public int getCancelFundingNo() {
        return cancelFundingNo;
    }

    public void setCancelFundingNo(int cancelFundingNo) {
        this.cancelFundingNo = cancelFundingNo;
    }

    public int getCancelFundingCategoryNo() {
        return cancelFundingCategoryNo;
    }

    public void setCancelFundingCategoryNo(int cancelFundingCategoryNo) {
        this.cancelFundingCategoryNo = cancelFundingCategoryNo;
    }

    public String getCancelFundingContent() {
        return cancelFundingContent;
    }

    public void setCancelFundingContent(String cancelFundingContent) {
        this.cancelFundingContent = cancelFundingContent;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    @Override
    public String toString() {
        return "CancelFunding{" +
                "cancelFundingNo=" + cancelFundingNo +
                ", cancelFundingCategoryNo=" + cancelFundingCategoryNo +
                ", cancelFundingContent='" + cancelFundingContent + '\'' +
                ", fundingInfoNo=" + fundingInfoNo +
                '}';
    }
}
