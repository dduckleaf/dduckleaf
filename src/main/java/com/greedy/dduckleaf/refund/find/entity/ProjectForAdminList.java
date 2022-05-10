package com.greedy.dduckleaf.refund.find.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForAdminRefundingFind")
@Table(name = "TBL_PROJECT")
public class ProjectForAdminList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus progressStatus;

    @Column(name = "OPEN_DATE")
    private String openDate;

    @Column(name = "END_DATE")
    private String endDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FARMER_NO")
    private Farmer farmer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private List<FundingCount> fundings;
}
