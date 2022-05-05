package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectProgressStatusForMyFunding")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int projectProgressStatusNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String projectProgressStatusName;
}
