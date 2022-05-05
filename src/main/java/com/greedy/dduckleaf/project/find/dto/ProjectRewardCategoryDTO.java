package com.greedy.dduckleaf.project.find.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectRewardCategoryDTO {

    private int projectCategoryNo;
    private String projectCategoryName;
}
