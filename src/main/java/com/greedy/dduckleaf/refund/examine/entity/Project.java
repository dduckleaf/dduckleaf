package com.greedy.dduckleaf.refund.examine.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForRefundingFarmerExamine")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private RewardInfo rewardInfo;

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private List<Funding> fundings;

    @Column(name = "FUND_TARGET_AMOUNT")
    private int fundTargetAmount;

    @Column(name = "ACHIEVEMENT_RATE")
    private double achievementRate;
}
