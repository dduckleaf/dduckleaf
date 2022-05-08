package com.greedy.dduckleaf.project.entity;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import com.greedy.dduckleaf.projectapplication.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "projectApplicationInfoForProjectDetail")
@Table(name = "TBL_PROJECT_APPLICATION_INFO")
public class ProjectApplicationInfo {

    @Id
    @Column(name = "PROJECT_APPLICATION_NO")
    private int projectApplicationNo;

    @Column(name = "PROJECT_APPICATION_CATEGORY")
    private String projectApplicationCategory;  //구분

    @JoinColumn(name = "PROJECT_BASIC_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProjectBasicInfo projectBasicInfo;             //기본 정보 번호

    @JoinColumn(name = "PROJECT_SHIPPING_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProjectShippingInfo projectShippingInfo;          //발송 정보 번호

    @JoinColumn(name = "REWARD_REGIST_INFO_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RewardRegistInfo rewardRegistInfo;             //리워드 등록 정보 번호

    @JoinColumn(name = "REFUND_POLICY_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RefundPolicy refundPolicy;                 //환불 정책 번호

    @JoinColumn(name = "PROJECT_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Project project;

    @JoinColumn(name = "MEMBER_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private FarmerInfo farmer;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private FarmerFinancialInfo farmer;

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
