package com.greedy.dduckleaf.funding.dto;

import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import org.springframework.data.domain.Page;

public class RefundingFindDetailInfoDTO {

    private ProjectDTO project;
    private Page<RefundingDTO> refundings;

    public RefundingFindDetailInfoDTO() {
    }

    public RefundingFindDetailInfoDTO(ProjectDTO project, Page<RefundingDTO> refundings) {
        this.project = project;
        this.refundings = refundings;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public Page<RefundingDTO> getRefundings() {
        return refundings;
    }

    public void setRefundings(Page<RefundingDTO> refundings) {
        this.refundings = refundings;
    }
}
