package com.greedy.dduckleaf.projectapplication.dto;

public class ProjectAttachmentDTO {

    private int projectAttachmentNo;
    private String projectAttachmentCategory;
    private String projectAttachmentSavePath;
    private String projectAttachmentSaveName;
    private String projectAttachmentOriginalName;
    private int farmerNo;
    private ProjectDTO project;

    public ProjectAttachmentDTO() {
    }

    public ProjectAttachmentDTO(int projectAttachmentNo, String projectAttachmentCategory, String projectAttachmentSavePath, String projectAttachmentSaveName, String projectAttachmentOriginalName, int farmerNo, ProjectDTO project) {
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

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectAttachmentDTO{" +
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
