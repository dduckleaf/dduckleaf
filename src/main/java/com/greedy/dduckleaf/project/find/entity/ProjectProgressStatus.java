package com.greedy.dduckleaf.project.find.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectProgressStatusForProjectList")
@Table(name ="TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int projectProgressStuatusNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String projectProgressStuatusName;
}
