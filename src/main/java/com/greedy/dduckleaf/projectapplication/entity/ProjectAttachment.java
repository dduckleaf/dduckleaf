package com.greedy.dduckleaf.projectapplication.entity;

import javax.persistence.*;

@Entity(name = "ProjectAttachmentForProjectApplication")
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

    public ProjectAttachment() {
    }

    public ProjectAttachment(int projectAttachmentNo, String projectAttachmentCategory, String projectAttachmentSavePath, String projectAttachmentSaveName, String projectAttachmentOriginalName, int farmerNo, Project project) {
        this.projectAttachmentNo = projectAttachmentNo;
        this.projectAttachmentCategory = projectAttachmentCategory;
        this.projectAttachmentSavePath = projectAttachmentSavePath;
        this.projectAttachmentSaveName = projectAttachmentSaveName;
        this.projectAttachmentOriginalName = projectAttachmentOriginalName;
        this.farmerNo = farmerNo;
        this.project = project;
    }

    public int getProjectAttachmentNo() {
        return projectAttachmentNo;
    }

    public void setProjectAttachmentNo(int projectAttachmentNo) {
        this.projectAttachmentNo = projectAttachmentNo;
    }

    public String getProjectAttachmentCategory() {
        return projectAttachmentCategory;
    }

    public void setProjectAttachmentCategory(String projectAttachmentCategory) {
        this.projectAttachmentCategory = projectAttachmentCategory;
    }

    public String getProjectAttachmentSavePath() {
        return projectAttachmentSavePath;
    }

    public void setProjectAttachmentSavePath(String projectAttachmentSavePath) {
        this.projectAttachmentSavePath = projectAttachmentSavePath;
    }

    public String getProjectAttachmentSaveName() {
        return projectAttachmentSaveName;
    }

    public void setProjectAttachmentSaveName(String projectAttachmentSaveName) {
        this.projectAttachmentSaveName = projectAttachmentSaveName;
    }

    public String getProjectAttachmentOriginalName() {
        return projectAttachmentOriginalName;
    }

    public void setProjectAttachmentOriginalName(String projectAttachmentOriginalName) {
        this.projectAttachmentOriginalName = projectAttachmentOriginalName;
    }

    public int getFarmerNo() {
        return farmerNo;
    }

    public void setFarmerNo(int farmerNo) {
        this.farmerNo = farmerNo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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
