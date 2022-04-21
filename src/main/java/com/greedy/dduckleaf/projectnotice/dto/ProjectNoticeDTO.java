package com.greedy.dduckleaf.projectnotice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectNoticeDTO {

    private int projectNoticeNo;
    private String projectNoticeContent;
    private int projectNo;
    private java.sql.Date registDate;
    private String projectNoticeStatus;
    private String projectNoticeTitle;
    private int projectNoticeCount;
    private int farmerNo;

}
