package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectApplyFeeInfoForProjectApplication")
@Table(name = "TBL_PROJECT_APPLY_FEE_INFO")
@DynamicInsert
public class ProjectApplyFeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_APPLY_FEE_INFO_NO")
    private int projectApplyFeeInfoNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FEE_POLICY_RATE_NO")
    private int feePolicyRateNo;
}
