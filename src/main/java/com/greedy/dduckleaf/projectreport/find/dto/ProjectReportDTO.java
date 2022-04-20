package com.greedy.dduckleaf.projectreport.find.dto;

import com.greedy.dduckleaf.projectreport.find.entity.Project;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

    import lombok.*;

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @ToString
public class ProjectReportDTO {
    private int projectReportNo;
    private Date projectReportDate;
    private String projectReportContent;
    private String reportRefUrl;
    private String reporterPhone;
    private String reporterEmail;
    private String reporterName;
    private int memberNo;
    private Project project;
    private String projectReportStatus;
}
