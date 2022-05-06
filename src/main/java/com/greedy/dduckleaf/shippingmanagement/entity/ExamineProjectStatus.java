package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ShippingForExamineProjectStatus")
@Table(name = "TBL_EXAMINE_PROJECT_STATUS")
public class ExamineProjectStatus {

    @Id
    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatusCode;

    @Column(name = "EXAMINE_PROJECT_STATUS_NAME")
    private String examineProjectStatusName;

    @OneToMany(mappedBy = "examineStatus")
    private List<Project> projectList;

    @Override
    public String toString() {
        return "ExamineProjectStatus{" +
                "examineProjectStatusCode=" + examineProjectStatusCode +
                ", examineProjectStatusName='" + examineProjectStatusName + '\'' +
                '}';
    }
}
