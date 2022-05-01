package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectAttachmentForProjectApplication")
@Table(name = "TBL_PROJECT_ATTACHMENT")
public class ProjectAttachment {

    @Id
    @Column(name = "PROJECT_ATTACHMENT_NO")
    private int projectAttachmentNo;

    @Column(name = "PROJECT_ATTACHMENT_CATEGORY")
    private String projectAttachmentCategory;

    @Column(name = "PROJECT_ATTACHMENT_SAVE_PATH")
    private String projectAttachmentSavePath;

    @Column(name = "PROJECT_ATTACHMENT_SAVE_NAME")
    private String projectAttachmentSaveName;

    @Column(name = "PROJECT_ATTACHMENT_ORIGINAL_NAME")
    private String projectAttachmentOriginalName;

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Column(name = "PROJECT_BASIC_INFO_NO")
    private int projectBasicInfoNo;                 //기본정보번호

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Override
    public String toString() {
        return "ProjectAttachment{" +
                "projectAttachmentNo=" + projectAttachmentNo +
                ", projectAttachmentCategory='" + projectAttachmentCategory + '\'' +
                ", projectAttachmentSavePath='" + projectAttachmentSavePath + '\'' +
                ", projectAttachmentSaveName='" + projectAttachmentSaveName + '\'' +
                ", projectAttachmentOriginalName='" + projectAttachmentOriginalName + '\'' +
                ", farmerNo=" + farmerNo +
                ", projectBasicInfoNo=" + projectBasicInfoNo +
                ", projectNo=" + projectNo +
                '}';
    }
}
