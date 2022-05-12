package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MemberForShipping")
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;           //회원 번호

    @Column(name = "MEMBER_NAME")
    private String memberName;      //회원 이름

    @OneToMany(mappedBy = "farmer")
    private List<Project> projectList;          //프로젝트 엔티티 1:N 매핑

    @OneToMany(mappedBy = "member")
    private List<FundingInfo> fundingInfoList;  //펀딩 신청 내역 엔티티 1:N 매핑

    public Member() {}

    public Member(int memberNo, String memberName, List<Project> projectList, List<FundingInfo> fundingInfoList) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.projectList = projectList;
        this.fundingInfoList = fundingInfoList;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<FundingInfo> getFundingInfoList() {
        return fundingInfoList;
    }

    public void setFundingInfoList(List<FundingInfo> fundingInfoList) {
        this.fundingInfoList = fundingInfoList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
