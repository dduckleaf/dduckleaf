package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectProgressStatusForRefundFind")
@Table(name = "TBL_PROJECT_PROGRESS_STATUS")
public class ProjectProgressStatus {

    @Id
    @Column(name = "PROJECT_PROGRESS_STATUS_NO")
    private int progressNo;

    @Column(name = "PROJECT_PROGRESS_STATUS_NAME")
    private String progressName;

    public ProjectProgressStatus() {
    }

    public ProjectProgressStatus(int progressNo, String progressName) {
        this.progressNo = progressNo;
        this.progressName = progressName;
    }

    public int getProgressNo() {
        return progressNo;
    }

    public void setProgressNo(int progressNo) {
        this.progressNo = progressNo;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    @Override
    public String toString() {
        return "ProjectProgressStatus{" +
                "progressNo=" + progressNo +
                ", progressName='" + progressName + '\'' +
                '}';
    }
}
