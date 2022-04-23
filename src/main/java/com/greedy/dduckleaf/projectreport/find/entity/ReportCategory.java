package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "reportCategory")
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
