package com.greedy.dduckleaf.funding.find.member.dto;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.MemberDTO;
import com.greedy.dduckleaf.funding.dto.ProjectDTO;
import org.springframework.data.domain.Page;

public class ProjectManageFundingDTO {

    private Page<FundingDTO> fundingInfos;
    private ProjectDTO project;

    public ProjectManageFundingDTO() {
    }

    public ProjectManageFundingDTO(Page<FundingDTO> fundingInfos, ProjectDTO project) {
        this.fundingInfos = fundingInfos;
        this.project = project;
    }

    public Page<FundingDTO> getFundingInfos() {
        return fundingInfos;
    }

    public void setFundingInfos(Page<FundingDTO> fundingInfos) {
        this.fundingInfos = fundingInfos;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectManageFundingDTO{" +
                "fundingInfos=" + fundingInfos +
                ", project=" + project +
                '}';
    }
}
