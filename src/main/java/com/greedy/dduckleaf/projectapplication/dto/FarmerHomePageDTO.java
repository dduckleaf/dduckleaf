package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FarmerHomePageDTO { //파머홈페이지

    private int farmerHomepageNo;
    private String homepageURL;
    private int homepageCategoryNo;     //홈페이지구분번호
    private int farmerNo;
}
