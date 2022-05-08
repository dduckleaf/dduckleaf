package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForMember")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    @OneToOne
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus projectProgressStatus;

    @OneToOne
    @JoinColumn(name = "FARMER_NO")
    private Farmer farmer;
}
