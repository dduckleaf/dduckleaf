package com.greedy.dduckleaf.project.find.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectAttachmentForMainPageProjectList")
@Table(name = "TBL_PROJECT_ATTACHMENT")
public class ProjectAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ATTACHMENT_NO")
    private int projectAttachmentNo;

    @Column(name = "PROJECT_ATTACHMENT_SAVE_NAME")
    private String projectAttachmentSaveName;
}
