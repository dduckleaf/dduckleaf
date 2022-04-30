package com.greedy.dduckleaf.project.find.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class SearchDTO {
    private String searchValue;
    private Integer rewardCategory;
    private Integer progressStatus;

    public SearchDTO(String searchValue, Integer rewardCategory, Integer progressStatus) {
        this.searchValue = searchValue == null? "": searchValue;
        this.rewardCategory = rewardCategory;
        this.progressStatus = progressStatus;
    }
}
