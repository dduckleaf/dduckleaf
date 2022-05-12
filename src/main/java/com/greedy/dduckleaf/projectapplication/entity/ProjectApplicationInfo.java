package com.greedy.dduckleaf.projectapplication.entity;

import com.greedy.dduckleaf.projectapplication.dto.ProjectBasicInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "projectApplicationInfo")
@Table(name = "TBL_PROJECT_APPLICATION_INFO")
public class ProjectApplicationInfo {

    @Id
    @Column(name = "PROJECT_APPLICATION_NO")
    private int projectApplicationNo;

    @Column(name = "PROJECT_APPICATION_CATEGORY")
    private String projectApplicationCategory;                  //구분

    @JoinColumn(name = "PROJECT_BASIC_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProjectBasicInfo projectBasicInfo;                  //기본 정보 번호

    @JoinColumn(name = "PROJECT_SHIPPING_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProjectShippingInfo projectShippingInfo;            //발송 정보 번호

    @JoinColumn(name = "REWARD_REGIST_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RewardRegistInfo rewardRegistInfo;                  //리워드 등록 정보 번호

    @JoinColumn(name = "REFUND_POLICY_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RefundPolicy refundPolicy;                          //환불 정책 번호

    @JoinColumn(name = "PROJECT_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Project project;

    @JoinColumn(name = "MEMBER_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private FarmerInfo farmer;

    public ProjectApplicationInfo() {
    }

    public ProjectApplicationInfo(int projectApplicationNo, String projectApplicationCategory, ProjectBasicInfo projectBasicInfo, ProjectShippingInfo projectShippingInfo, RewardRegistInfo rewardRegistInfo, RefundPolicy refundPolicy, Project project, FarmerInfo farmer) {
        this.projectApplicationNo = projectApplicationNo;
        this.projectApplicationCategory = projectApplicationCategory;
        this.projectBasicInfo = projectBasicInfo;
        this.projectShippingInfo = projectShippingInfo;
        this.rewardRegistInfo = rewardRegistInfo;
        this.refundPolicy = refundPolicy;
        this.project = project;
        this.farmer = farmer;
    }

    public int getProjectApplicationNo() {
        return projectApplicationNo;
    }

    public void setProjectApplicationNo(int projectApplicationNo) {
        this.projectApplicationNo = projectApplicationNo;
    }

    public String getProjectApplicationCategory() {
        return projectApplicationCategory;
    }

    public void setProjectApplicationCategory(String projectApplicationCategory) {
        this.projectApplicationCategory = projectApplicationCategory;
    }

    public ProjectBasicInfo getProjectBasicInfo() {
        return projectBasicInfo;
    }

    public void setProjectBasicInfo(ProjectBasicInfo projectBasicInfo) {
        this.projectBasicInfo = projectBasicInfo;
    }

    public ProjectShippingInfo getProjectShippingInfo() {
        return projectShippingInfo;
    }

    public void setProjectShippingInfo(ProjectShippingInfo projectShippingInfo) {
        this.projectShippingInfo = projectShippingInfo;
    }

    public RewardRegistInfo getRewardRegistInfo() {
        return rewardRegistInfo;
    }

    public void setRewardRegistInfo(RewardRegistInfo rewardRegistInfo) {
        this.rewardRegistInfo = rewardRegistInfo;
    }

    public RefundPolicy getRefundPolicy() {
        return refundPolicy;
    }

    public void setRefundPolicy(RefundPolicy refundPolicy) {
        this.refundPolicy = refundPolicy;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public FarmerInfo getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerInfo farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "ProjectApplicationInfo{" +
                "projectApplicationNo=" + projectApplicationNo +
                ", projectApplicationCategory='" + projectApplicationCategory + '\'' +
                ", projectBasicInfo=" + projectBasicInfo +
                ", projectShippingInfo=" + projectShippingInfo +
                ", rewardRegistInfo=" + rewardRegistInfo +
                ", refundPolicy=" + refundPolicy +
                ", project=" + project +
                ", farmer=" + farmer +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectApplicationCategory = this.projectApplicationCategory  == null ? "심사대기중" : this.projectApplicationCategory ;

    }
}
