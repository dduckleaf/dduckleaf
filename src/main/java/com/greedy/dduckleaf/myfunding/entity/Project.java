package com.greedy.dduckleaf.myfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ProjectForMyFunding")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus projectProgressStatus;

    public Project() {
    }

    public Project(int projectNo, ProjectProgressStatus projectProgressStatus) {
        this.projectNo = projectNo;
        this.projectProgressStatus = projectProgressStatus;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public ProjectProgressStatus getProjectProgressStatus() {
        return projectProgressStatus;
    }

    public void setProjectProgressStatus(ProjectProgressStatus projectProgressStatus) {
        this.projectProgressStatus = projectProgressStatus;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectProgressStatus=" + projectProgressStatus +
                '}';
    }
}
