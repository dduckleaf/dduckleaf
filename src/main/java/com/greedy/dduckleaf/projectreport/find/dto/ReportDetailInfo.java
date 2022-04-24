package com.greedy.dduckleaf.projectreport.find.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReportDetailInfo {

    private ProjectReportDTO projectReport;
    private ProjectReportReplyDTO projectReportReply;
}
