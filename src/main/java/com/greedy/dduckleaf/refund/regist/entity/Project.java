package com.greedy.dduckleaf.refund.regist.entity;

import javax.persistence.*;

@Entity(name = "ProjectForRefundingRegist")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "FARMER_NO")
    private Member farmer;

    public Project() {
    }

    public Project(int projectNo, Member farmer) {
        this.projectNo = projectNo;
        this.farmer = farmer;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public Member getFarmer() {
        return farmer;
    }

    public void setFarmer(Member farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", farmer=" + farmer +
                '}';
    }
}