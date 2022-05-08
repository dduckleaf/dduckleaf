package com.greedy.dduckleaf.farmingrecord.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FarmingRecordDTO {

    private int farmingRecordNo;
    private int projectNo;
    private String farmingRecordTitle;
    private String farmingRecordContent;
    private String farmingRecordUploadDate;
    private String publicStatus;
    private String farmingRecordStatus;
    private int farmingRecordCount;
    private int farmerNo;

}
