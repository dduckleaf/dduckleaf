package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "projectProgressStatusForProjectApplication")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int projectProgressStatusNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String projectProgressStatusName;

    @Override
    public String toString() {
        return "ProjectProgressStatus{" +
                "projectProgressStatusNo=" + projectProgressStatusNo +
                ", projectProgressStatusName='" + projectProgressStatusName + '\'' +
                '}';
    }
}
