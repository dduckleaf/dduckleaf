package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProjectForFundingRegist")
@Table(name = "TBL_PROJECT")
public class ProjectForFundingRegist {
    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @OneToMany
    @JoinColumn(name = "PROJECT_NO")
    private List<RewardInfo> rewardInfo;

    @OneToMany
    @JoinColumn(name = "PROJECT_NO")
    private List<ProjectShippingFee> projectShippingFee;

    public ProjectForFundingRegist() {
    }

    public ProjectForFundingRegist(int projectNo, String projectName, List<RewardInfo> rewardInfo, List<ProjectShippingFee> projectShippingFee) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.rewardInfo = rewardInfo;
        this.projectShippingFee = projectShippingFee;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<RewardInfo> getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(List<RewardInfo> rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public List<ProjectShippingFee> getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(List<ProjectShippingFee> projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
    }

    @Override
    public String toString() {
        return "ProjectForFundingRegist{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
