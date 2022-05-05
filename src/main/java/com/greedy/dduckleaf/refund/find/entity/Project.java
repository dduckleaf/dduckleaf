package com.greedy.dduckleaf.refund.find.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForRefundingFind")
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
}
