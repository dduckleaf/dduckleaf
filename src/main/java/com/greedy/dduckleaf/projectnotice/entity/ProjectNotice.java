package com.greedy.dduckleaf.projectnotice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ProjectNotice")
@Table(name = "TBL_PROJECT_NOTICE")
public class ProjectNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NOTICE_NO")
    private int projectNoticeNo;

    @Column(name = "PROJECT_NOTICE_CONTENT")
    private String projectNoticeContent;

    @Override
    public String toString() {
        return "ProjectNotice{" +
                "projectNoticeNo=" + projectNoticeNo +
                ", projectNoticeContent='" + projectNoticeContent + '\'' +
                '}';
    }
}
