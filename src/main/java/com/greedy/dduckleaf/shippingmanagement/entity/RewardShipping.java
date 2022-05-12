package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

@Entity(name = "RewardShippingForShipping")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;           //발송 번호

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;         //발송 예정일

    @Column(name = "MEMBER_NO")
    private int memberNo;                   //회원 번호

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                //프로젝트 엔티티 N:1 매핑

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private FundingInfo fundingInfo;        //펀딩 신청 내역 엔티티 N:1 매핑

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SHIPPING_STATUS_NO")
    private ShippingStatus shippingStatus;  //발송 상태 엔티티 N:1 매핑

    public RewardShipping() {}

    public RewardShipping(int rewardShippingNo, String shippingDueDate, int memberNo, Project project, FundingInfo fundingInfo, ShippingStatus shippingStatus) {
        this.rewardShippingNo = rewardShippingNo;
        this.shippingDueDate = shippingDueDate;
        this.memberNo = memberNo;
        this.project = project;
        this.fundingInfo = fundingInfo;
        this.shippingStatus = shippingStatus;
    }

    public int getRewardShippingNo() {
        return rewardShippingNo;
    }

    public void setRewardShippingNo(int rewardShippingNo) {
        this.rewardShippingNo = rewardShippingNo;
    }

    public String getShippingDueDate() {
        return shippingDueDate;
    }

    public void setShippingDueDate(String shippingDueDate) {
        this.shippingDueDate = shippingDueDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public FundingInfo getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfo fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    @Override
    public String toString() {
        return "RewardShipping{" +
                "rewardShippingNo=" + rewardShippingNo +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                ", memberNo=" + memberNo +
                ", project=" + project +
                ", shippingStatus=" + shippingStatus +
                '}';
    }
}
