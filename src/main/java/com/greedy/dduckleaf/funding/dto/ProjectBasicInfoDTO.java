package com.greedy.dduckleaf.funding.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectBasicInfoDTO {

    private int projectRegistInfoNo;
    private ProjectRewardCategoryDTO category;
}
