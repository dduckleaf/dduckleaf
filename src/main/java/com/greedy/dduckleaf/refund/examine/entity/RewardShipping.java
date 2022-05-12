package com.greedy.dduckleaf.refund.examine.entity;

import javax.persistence.*;

@Entity(name = "RewardShippingForRefundingFarmerExamine")
@Table(name = "TBL_REWARD_SHIPPING")
public class RewardShipping {

    @Id
    @Column(name = "REWARD_SHIPPING_NO")
    private int rewardShippingNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;

    public RewardShipping() {
    }

    public RewardShipping(int rewardShippingNo, int memberNo, int projectNo, Funding funding, String shippingDueDate) {
        this.rewardShippingNo = rewardShippingNo;
        this.memberNo = memberNo;
        this.projectNo = projectNo;
        this.funding = funding;
        this.shippingDueDate = shippingDueDate;
    }

    public int getRewardShippingNo() {
        return rewardShippingNo;
    }

    public void setRewardShippingNo(int rewardShippingNo) {
        this.rewardShippingNo = rewardShippingNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public Funding getFunding() {
        return funding;
    }

    public void setFunding(Funding funding) {
        this.funding = funding;
    }

    public String getShippingDueDate() {
        return shippingDueDate;
    }

    public void setShippingDueDate(String shippingDueDate) {
        this.shippingDueDate = shippingDueDate;
    }

    @Override
    public String toString() {
        return "RewardShipping{" +
                "rewardShippingNo=" + rewardShippingNo +
                ", memberNo=" + memberNo +
                ", projectNo=" + projectNo +
                ", funding=" + funding +
                ", shippingDueDate='" + shippingDueDate + '\'' +
                '}';
    }
}