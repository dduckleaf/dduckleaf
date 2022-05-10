package com.greedy.dduckleaf.project.entity;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectAttachmentForProjectDetail")
@Table(name = "TBL_PROJECT_ATTACHMENT")
public class ProjectAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @Override
    public String toString() {
        return "ProjectAttachment{" +
                "projectAttachmentNo=" + projectAttachmentNo +
                ", projectAttachmentCategory='" + projectAttachmentCategory + '\'' +
                ", projectAttachmentSavePath='" + projectAttachmentSavePath + '\'' +
                ", projectAttachmentSaveName='" + projectAttachmentSaveName + '\'' +
                ", projectAttachmentOriginalName='" + projectAttachmentOriginalName + '\'' +
                ", farmerNo=" + farmerNo +
                ", project=" + project +
                '}';
    }
}
