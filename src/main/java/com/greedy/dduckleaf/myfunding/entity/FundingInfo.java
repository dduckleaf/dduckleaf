package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.*;

@Entity(name = "FundingInfoForMyFunding")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    public FundingInfo() {
    }

    public FundingInfo(int fundingInfoNo, Member member, Project project) {
        this.fundingInfoNo = fundingInfoNo;
        this.member = member;
        this.project = project;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "FundingInfo{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", member=" + member +
                ", project=" + project +
                '}';
    }
}
