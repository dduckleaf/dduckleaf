package com.greedy.dduckleaf.funding.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectRegistInfoDTO {
    private int projectRegistInfoNo;
    private int projectNo;
    private String projectRegistInfoCategory;
    private ProjectRewardCategoryDTO category;
}
