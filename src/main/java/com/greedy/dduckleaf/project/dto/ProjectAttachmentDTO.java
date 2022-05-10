package com.greedy.dduckleaf.project.dto;

import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
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
    private ProjectDTO project;
}
