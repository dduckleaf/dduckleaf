package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectExamineHistoryCategoryForProjectApplication")
@Table(name = "TBL_PROJECT_EXAMINE_HISTORY")
@DynamicInsert
public class ProjectExamineHistoryCategory {

    @Id
    @Column(name = "PROJECT_EXAMINE_HISTORY_CATEGORY_NO")
    private int projectExamineHistoryCategoryNo;

    @Column(name = "PROJECT_EXAMINE_HISTORY_CATEGORY_NAME")
    private String projectExamineHistoryCategoryName;

//    @OneToMany(mappedBy = "examineProjectStatus")
//    private List<ProjectExamineHistory> projectExamineHistoryList;

    @Override
    public String toString() {
        return "ProjectExamineHistoryCategory{" +
                "projectExamineHistoryCategoryNo=" + projectExamineHistoryCategoryNo +
                ", projectExamineHistoryCategoryName='" + projectExamineHistoryCategoryName + '\'' +
                '}';
    }
}
