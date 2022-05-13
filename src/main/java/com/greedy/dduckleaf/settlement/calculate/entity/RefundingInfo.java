package com.greedy.dduckleaf.settlement.calculate.entity;

import javax.persistence.*;

@Entity(name = "RefundingInfoForSettlement")
@Table(name = "TBL_REFUNDING")
public class RefundingInfo {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;                    //환불 신청 번호

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;                   //환불 신청일

    @Transient
    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;                //환불 구분 번호

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_STATUS_NO")
    private RefundingStatus refundingStatus;        //환불상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                        //프로젝트 번호

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;                //환불처리종료일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private FundingInfo fundingInfo;                //펀딩내역번호

    public RefundingInfo() {}

    public RefundingInfo(int refundingInfoNo, String refundingDate, int refundingCategoryNo,
                         RefundingStatus refundingStatus, Project project, String refundingEndDate, FundingInfo fundingInfo) {
        this.refundingInfoNo = refundingInfoNo;
        this.refundingDate = refundingDate;
        this.refundingCategoryNo = refundingCategoryNo;
        this.refundingStatus = refundingStatus;
        this.project = project;
        this.refundingEndDate = refundingEndDate;
        this.fundingInfo = fundingInfo;
    }

    public int getRefundingInfoNo() {
        return refundingInfoNo;
    }

    public void setRefundingInfoNo(int refundingInfoNo) {
        this.refundingInfoNo = refundingInfoNo;
    }

    public String getRefundingDate() {
        return refundingDate;
    }

    public void setRefundingDate(String refundingDate) {
        this.refundingDate = refundingDate;
    }

    public int getRefundingCategoryNo() {
        return refundingCategoryNo;
    }

    public void setRefundingCategoryNo(int refundingCategoryNo) {
        this.refundingCategoryNo = refundingCategoryNo;
    }

    public RefundingStatus getRefundingStatus() {
        return refundingStatus;
    }

    public void setRefundingStatus(RefundingStatus refundingStatus) {
        this.refundingStatus = refundingStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRefundingEndDate() {
        return refundingEndDate;
    }

    public void setRefundingEndDate(String refundingEndDate) {
        this.refundingEndDate = refundingEndDate;
    }

    public FundingInfo getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfo fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    @Override
    public String toString() {
        return "RefundingInfo{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingCategoryNo=" + refundingCategoryNo +
                ", refundingStatus=" + refundingStatus +
                ", project=" + project +
                ", refundingEndDate='" + refundingEndDate + '\'' +
                '}';
    }
}
