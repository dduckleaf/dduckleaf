package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectAttachmentDTO {

    private int projectAttachmentNo;
    private String projectAttachmentCategory;
    private String projectAttachmentSavePath;
    private String projectAttachmentSaveName;
    private String projectAttachmentOriginalName;
    private int farmerNo;
//    private int projectBasicInfoNo;                 //기본정보번호
    private int projectNo;
//    private int financialInfoNo;
}
