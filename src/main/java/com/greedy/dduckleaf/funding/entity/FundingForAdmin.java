package com.greedy.dduckleaf.funding.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FundingForAdmin")
@Table(name = "TBL_FUNDING_INFO")
public class FundingForAdmin {


    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private String fundingDate;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private List<Refunding> refundings;

    public FundingForAdmin() {
    }

    public FundingForAdmin(int fundingInfoNo, String fundingDate, int memberNo, List<Refunding> refundings) {
        this.fundingInfoNo = fundingInfoNo;
        this.fundingDate = fundingDate;
        this.memberNo = memberNo;
        this.refundings = refundings;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    public String getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(String fundingDate) {
        this.fundingDate = fundingDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public List<Refunding> getRefundings() {
        return refundings;
    }

    public void setRefundings(List<Refunding> refundings) {
        this.refundings = refundings;
    }

    @Override
    public String toString() {
        return "FundingForAdmin{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate='" + fundingDate + '\'' +
                ", memberNo=" + memberNo +
                '}';
    }
}