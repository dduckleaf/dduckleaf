package com.greedy.dduckleaf.main.entity;

import javax.persistence.*;

@Entity(name = "ProjectAttachmentForMain")
@Table(name = "TBL_PROJECT_ATTACHMENT")
public class ProjectAttachment {

    @Id
    @Column(name = "PROJECT_ATTACHMENT_NO")
    private int projectAttachmentNo;

    @Column(name = "PROJECT_ATTACHMENT_SAVE_NAME")
    private String projectAttachmentSaveName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    public ProjectAttachment() {
    }

    public ProjectAttachment(int projectAttachmentNo, String projectAttachmentSaveName, Project project) {
        this.projectAttachmentNo = projectAttachmentNo;
        this.projectAttachmentSaveName = projectAttachmentSaveName;
        this.project = project;
    }

    public int getProjectAttachmentNo() {
        return projectAttachmentNo;
    }

    public void setProjectAttachmentNo(int projectAttachmentNo) {
        this.projectAttachmentNo = projectAttachmentNo;
    }

    public String getProjectAttachmentSaveName() {
        return projectAttachmentSaveName;
    }

    public void setProjectAttachmentSaveName(String projectAttachmentSaveName) {
        this.projectAttachmentSaveName = projectAttachmentSaveName;
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
                ", projectAttachmentSaveName='" + projectAttachmentSaveName + '\'' +
                ", project=" + project +
                '}';
    }
}
