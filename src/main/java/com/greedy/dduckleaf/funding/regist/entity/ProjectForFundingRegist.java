package com.greedy.dduckleaf.funding.regist.entity;

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

    @OneToOne
    @JoinColumn(name = "PROJECT_NO")
    private RewardInfo rewardInfo;

    @OneToOne
    @JoinColumn(name = "PROJECT_NO")
    private ProjectShippingFee projectShippingFee;

    public ProjectForFundingRegist() {
    }

    public ProjectForFundingRegist(int projectNo, String projectName, RewardInfo rewardInfo, ProjectShippingFee projectShippingFee) {
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

    public RewardInfo getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(RewardInfo rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public ProjectShippingFee getProjectShippingFee() {
        return projectShippingFee;
    }

    public void setProjectShippingFee(ProjectShippingFee projectShippingFee) {
        this.projectShippingFee = projectShippingFee;
    }

    @Override
    public String toString() {
        return "ProjectForFundingRegist{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", rewardInfo=" + rewardInfo +
                ", projectShippingFee=" + projectShippingFee +
                '}';
    }
}
