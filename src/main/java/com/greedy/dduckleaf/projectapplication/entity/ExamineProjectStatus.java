package com.greedy.dduckleaf.projectapplication.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ExamineProjectStatusForProjectApplication")
@Table(name = "TBL_EXAMINE_PROJECT_STATUS")
@DynamicInsert
public class ExamineProjectStatus {

    @Id
    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatusCode;

    @Column(name = "EXAMINE_PROJECT_STATUS_NAME")
    private String examineProjectStatusName;

//    @OneToMany(mappedBy = "examineProjectStatus")
//    private List<ProjectExamineHistory> projectExamineHistoryList;

    @Override
    public String toString() {
        return "ExamineProjectStatus{" +
                "examineProjectStatusCode=" + examineProjectStatusCode +
                ", examineProjectStatusName='" + examineProjectStatusName + '\'' +
                '}';
    }
}
