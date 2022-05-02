package com.greedy.dduckleaf.projectapplication.entity;

import com.greedy.dduckleaf.projectapplication.dto.ProjectBasicInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "projectApplicationInfo")
@Table(name = "TBL_PROJECT_APPLICATION_INFO")
public class ProjectApplicationInfo {

    @Id
    @Column(name = "PROJECT_APPLICATION_NO")
    private int projectApplicationNo;

    @Column(name = "PROJECT_APPICATION_CATEGORY")
    private String projectApplicationCategory;  //구분

    @Column(name = "PROJECT_BASIC_INFO_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
    private int projectBasicInfoNo;             //기본 정보 번호

    @Column(name = "PROJECT_SHIPPING_INFO_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
    private int projectShippingInfoNo;          //발송 정보 번호

    @Column(name = "REWARD_REGIST_INFO_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
    private int rewardRegistInfoNo;             //리워드 등록 정보 번호

    @Column(name = "REFUND_POLICY_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
    private int refundPolicyNo;                 //환불 정책 번호

    @Column(name = "PROJECT_NO")
//    @ManyToOne(cascade = CascadeType.PERSIST)
    private int projectNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private FarmerFinancialInfo farmer;

    @Override
    public String toString() {
        return "ProjectApplicationInfo{" +
                "projectApplicationNo=" + projectApplicationNo +
                ", projectApplicationCategory='" + projectApplicationCategory + '\'' +
                ", projectBasicInfoNo=" + projectBasicInfoNo +
                ", projectShippingInfoNo=" + projectShippingInfoNo +
                ", rewardRegistInfoNo=" + rewardRegistInfoNo +
                ", refundPolicyNo=" + refundPolicyNo +
                ", projectNo=" + projectNo +
                ", memberNo=" + memberNo +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.projectApplicationCategory = this.projectApplicationCategory  == null ? "구분" : this.projectApplicationCategory ;

    }
}
