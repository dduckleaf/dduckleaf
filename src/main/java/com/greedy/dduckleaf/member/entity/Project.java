package com.greedy.dduckleaf.member.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForMember")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @OneToOne
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus projectProgressStatus;
}
