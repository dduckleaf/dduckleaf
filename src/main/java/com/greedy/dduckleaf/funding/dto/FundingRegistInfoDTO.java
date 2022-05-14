package com.greedy.dduckleaf.funding.dto;

import java.util.List;

public class FundingRegistInfoDTO {

    private List<BankDTO> bankList;
    private MemberDTO member;
    private ProjectDTO project;

    public FundingRegistInfoDTO() {
    }

    public FundingRegistInfoDTO(List<BankDTO> bankList, MemberDTO member, ProjectDTO project) {
        this.bankList = bankList;
        this.member = member;
        this.project = project;
    }

    public List<BankDTO> getBankList() {
        return bankList;
    }

    public void setBankList(List<BankDTO> bankList) {
        this.bankList = bankList;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }
}
