package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectExamineHistoryForProjectExamination")
@Table(name = "TBL_PROJECT_EXAMINE_HISTORY")
@DynamicInsert
public class ProjectExamineHistory {

    @Id
    @Column(name = "PROJECT_EXAMINE_HISTORY_NO")
    private int projectExamineHistoryNo;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @Column(name = "EXAMINE_HISTORY_CATEGORY_NO")
    private int examineHistoryCategory;       //프로젝트 승인 이력 구분 번호

    @Column(name = "PROJECT_EXAMINE_DETAIL_CONTENT")
    private String projectExamineDetailContent;

    @Column(name = "PROJECT_EXAMINE_REGIST_DATE")
    private String projectExamineRegistDate;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @Column(name = "EXAMINE_PROJECT_STATUS_CODE")
    private int examineProjectStatus;

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "ADMIN_NO")
    private int adminNo;

    @Override
    public String toString() {
        return "ProjectExamineHistory{" +
                "projectExamineHistoryNo=" + projectExamineHistoryNo +
                ", examineHistoryCategory=" + examineHistoryCategory +
                ", projectExamineDetailContent='" + projectExamineDetailContent + '\'' +
                ", projectExamineRegistDate='" + projectExamineRegistDate + '\'' +
                ", examineProjectStatus=" + examineProjectStatus +
                ", farmerNo=" + farmerNo +
                ", projectNo=" + projectNo +
                ", adminNo=" + adminNo +
                '}';
    }
}
