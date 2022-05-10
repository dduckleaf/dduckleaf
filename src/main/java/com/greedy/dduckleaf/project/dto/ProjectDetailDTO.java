package com.greedy.dduckleaf.project.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDetailDTO {

    private ProjectDTO project;
    private List<FundingInfoDTO> fundingInfoList;
    private String followingStatus;
    private ProjectApplicationInfoDTO projectApplicationInfo;
    private List<ProjectNoticeDTO> projectNotice;
    private List<ProjectAttachmentDTO> attachmentList;
}
