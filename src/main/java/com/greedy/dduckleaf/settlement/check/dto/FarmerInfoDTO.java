package com.greedy.dduckleaf.settlement.check.dto;

import java.util.List;

public class FarmerInfoDTO {

    private int memberNo;                               //회원번호
    private String farmerName;                          //파머 이름
    private String representativeName;                  //대표자명
    private String representativeEmail;                 //대표자이메일
    private List<ProjectDTO> projects;

    public FarmerInfoDTO() {}

    public FarmerInfoDTO(int memberNo, String farmerName, String representativeName, String representativeEmail, List<ProjectDTO> projects) {
        this.memberNo = memberNo;
        this.farmerName = farmerName;
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
        this.projects = projects;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRepresentativeEmail() {
        return representativeEmail;
    }

    public void setRepresentativeEmail(String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                '}';
    }
}
