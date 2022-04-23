package com.greedy.dduckleaf.projectreport.detail.entity;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "reportCategoryForProjectReportDetail")
@Table(name = "TBL_REPORT_CATEGORY")
public class ReportCategory {

    @Id
    @Column(name = "REPORT_CATEGORY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportCategoryNo;

    @Column(name = "REPORT_CATEGORY_NAME")
    private String reportCategoryName;

    @Column(name = "REPORT_CATEGORY_CONTENT")
    private String reportCategoryContent;

    @OneToMany(mappedBy = "reportCategory", fetch=FetchType.EAGER)
    private List<ProjectReport> projectReportList;

    @Override
    public String toString() {
        return "ReportCategory{" +
                "reportCategoryNo=" + reportCategoryNo +
                ", reportCategoryName='" + reportCategoryName + '\'' +
                ", reportCategoryContent='" + reportCategoryContent + '\'' +
                '}';
    }
}
